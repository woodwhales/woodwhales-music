package org.woodwhales.music.service.music.impl;

import cn.woodwhales.common.business.DataTool;
import cn.woodwhales.common.model.util.PageUtil;
import cn.woodwhales.common.model.vo.LayuiPageVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.music.controller.param.*;
import org.woodwhales.music.entity.Music;
import org.woodwhales.music.entity.MusicLink;
import org.woodwhales.music.enums.LinkStatusEnum;
import org.woodwhales.music.enums.MusicLinkSourceEnum;
import org.woodwhales.music.enums.MusicLinkTypeEnum;
import org.woodwhales.music.enums.StatusEnum;
import org.woodwhales.music.mapper.MusicMapper;
import org.woodwhales.music.model.*;

import java.time.Instant;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;

/**
 * 音乐接口实现类
 * @author woodwhales
 */
@Slf4j
@Primary
@Service
@Transactional(rollbackFor = Exception.class)
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> {
	
	@Autowired
	private MusicMapper musicMapper;

	@Autowired
	private MusicLinkServiceImpl musicLinkService;

    public List<MusicInfoVo> listMusic() {
		List<Music> musicList = musicMapper.selectList(Wrappers.<Music>lambdaQuery()
																.orderByAsc(Music::getStatus)
																.orderByAsc(Music::getSort)
																.orderByDesc(Music::getGmtModified));
		MusicInfoLinkContext musicInfoLinkContext = new MusicInfoLinkContext(musicList);
		return DataTool.filter(DataTool.toList(musicList,
								music -> LinkStatusEnum.LINKED.match(music.getLinkStatus()),
								music -> this.convert(music, musicInfoLinkContext)), music -> StringUtils.isNotBlank(music.getAudioUrl()));
    }

	public LayuiPageVO<MusicSimpleInfo> pageMusic(PageMusicQueryRequestParam param) {
		IPage<Music> page = PageUtil.buildPage(param);
		LambdaQueryWrapper<Music> wrapper = Wrappers.lambdaQuery();
		wrapper.and(StringUtils.isNotBlank(param.getSearchInfo()),
						i -> i.like(Music::getTitle, param.getSearchInfo())
								.or()
								.like(Music::getArtist, param.getSearchInfo())
								.or()
								.like(Music::getAlbum, param.getSearchInfo()))
				.and(i -> i.eq(Music::getStatus, StatusEnum.DEFAULT.code))
				.orderByAsc(Music::getSort);
		IPage<Music> pageResult = musicMapper.selectPage(page, wrapper);
		MusicInfoLinkContext musicInfoLinkContext = new MusicInfoLinkContext(pageResult.getRecords());
		return LayuiPageVO.build(pageResult, music -> this.convertSimpleInfo(music, musicInfoLinkContext), MusicSimpleInfo::compare);
	}

	public MusicDetailInfo getMusicDetailInfoById(Long id) {
		Music music = getMusicById(id);
		if(Objects.isNull(music)) {
			throw new RuntimeException("要访问的数据不存在");
		}
		MusicDetailInfo musicDetailInfo = new MusicDetailInfo();
		BeanUtils.copyProperties(music, musicDetailInfo);
		List<MusicInfoLinkDetailVo> linkList = musicLinkService.getLinkDetailVoListByMusicId(music.getId());
		musicDetailInfo.setLinkList(linkList);
		return musicDetailInfo;
	}

	public List<MusicInfoLinkDetailVo> getLinkList() {
		return musicLinkService.getLinkDetailVoListByMusicId(null);
	}

	private Music getMusicById(Long id) {
		Objects.requireNonNull(id, "不允许请求id为空");
		Music music = musicMapper.selectById(id);
		return music;
	}

	public boolean deleteMusic(MusicDeleteRequestBody requestBody) {
		Long id = requestBody.getId();
		Music music = getMusicById(id);
		if(Objects.isNull(music)) {
			throw new RuntimeException("要删除的数据不存在");
		}
		this.removeById(music.getId());
		musicLinkService.remove(Wrappers.<MusicLink>lambdaQuery()
				.eq(MusicLink::getMusicId, music.getId()));
		return true;
	}

    public MusicListInfo exportMusic() {
		List<MusicInfoVo> musicInfoVoList = listMusic();
		if(CollectionUtils.isEmpty(musicInfoVoList)) {
			return new MusicListInfo(StringUtils.EMPTY, 50);
		}
		StringBuilder stringBuilder = new StringBuilder("| 序号 | 音乐名称 | 专辑 | 作者 |\n");
		stringBuilder.append("| --- | ------ | ------ | --- |\n");
		Integer sequenceNo = 1;
		for (MusicInfoVo musicInfoVo : musicInfoVoList) {
			stringBuilder.append(String.format("| %d | %s | %s | %s |\n",
								sequenceNo++,
								StringUtils.isBlank(musicInfoVo.getTitle()) ? StringUtils.EMPTY : musicInfoVo.getTitle(),
							  	StringUtils.isBlank(musicInfoVo.getAlbum()) ? StringUtils.EMPTY : musicInfoVo.getAlbum(),
							  	StringUtils.isBlank(musicInfoVo.getArtist()) ? StringUtils.EMPTY : musicInfoVo.getArtist()));
		}
		return new MusicListInfo(stringBuilder.toString(), musicInfoVoList.size() + 3);
    }

	private MusicSimpleInfo convertSimpleInfo(Music music, MusicInfoLinkContext musicInfoLinkContext) {
		MusicSimpleInfo musicSimpleInfo = new MusicSimpleInfo();
		BeanUtils.copyProperties(music, musicSimpleInfo);
		musicSimpleInfo.setAudioUrl(musicInfoLinkContext.getAudioUrl(music.getId()));
		musicSimpleInfo.setCoverUrl(musicInfoLinkContext.getCoverUrl(music.getId()));
		musicSimpleInfo.setLinked(LinkStatusEnum.LINKED.match(music.getLinkStatus()));
		if(StringUtils.isBlank(musicSimpleInfo.getAudioUrl())) {
			musicSimpleInfo.setLinked(false);
		}
		return musicSimpleInfo;
	}

	private MusicInfoVo convert(Music music, MusicInfoLinkContext musicInfoLinkContext) {
		MusicInfoVo musicInfoVo = new MusicInfoVo();
    	musicInfoVo.setAlbum(music.getAlbum());
    	musicInfoVo.setArtist(music.getArtist());
    	musicInfoVo.setCoverUrl(musicInfoLinkContext.getCoverUrl(music.getId()));
    	musicInfoVo.setAudioUrl(musicInfoLinkContext.getAudioUrl(music.getId()));
    	musicInfoVo.setTitle(music.getTitle());
    	return musicInfoVo;
    }

	public void washLink() {
		List<Music> musicList = this.list();
		List<MusicLink> linkList = new ArrayList<>();
		for (Music music : musicList) {
			MusicLink audioLink = musicLinkService.getOne(Wrappers.<MusicLink>lambdaQuery()
					.eq(MusicLink::getMusicId, music.getId())
					.eq(MusicLink::getLinkType, MusicLinkTypeEnum.AUDIO_LINK.getCode())
					.eq(MusicLink::getLinkSource, MusicLinkSourceEnum.GITHUB.getCode()));
			if(Objects.isNull(audioLink)) {
				audioLink = new MusicLink();
			}
			audioLink.setMusicId(music.getId());
			audioLink.setLinkType(MusicLinkTypeEnum.AUDIO_LINK.getCode());
			audioLink.setLinkSource(MusicLinkSourceEnum.GITHUB.getCode());
			linkList.add(audioLink);

			MusicLink coverLink = musicLinkService.getOne(Wrappers.<MusicLink>lambdaQuery()
					.eq(MusicLink::getMusicId, music.getId())
					.eq(MusicLink::getLinkType, MusicLinkTypeEnum.COVER_LINK.getCode())
					.eq(MusicLink::getLinkSource, MusicLinkSourceEnum.GITHUB.getCode()));
			if(Objects.isNull(coverLink)) {
				coverLink = new MusicLink();
			}
			coverLink.setMusicId(music.getId());
			coverLink.setLinkType(MusicLinkTypeEnum.COVER_LINK.getCode());
			coverLink.setLinkSource(MusicLinkSourceEnum.GITHUB.getCode());
			linkList.add(coverLink);
		}
		musicLinkService.saveOrUpdateBatch(linkList);
	}

	public void createOrUpdate(MusicCreateOrUpdateRequestBody requestBody) {
		requestBody.trim();
		LinkStatusEnum linkStatusEnum = requestBody.checkLinkStatus();
		Music music;
		Instant now = Instant.now();
		if(Objects.isNull(requestBody.getId())) {
			music = new Music();
			music.setAlbum(requestBody.getAlbum());
			music.setArtist(requestBody.getArtist());
			music.setTitle(requestBody.getMusicName());
			music.setStatus(StatusEnum.DEFAULT.code);
			music.setGmtCreated(Date.from(now));
		} else {
			music = this.getMusicById(requestBody.getId());
			if(Objects.isNull(music)) {
				throw new RuntimeException("要更新的数据不存在");
			}
			music.setAlbum(defaultIfBlank(requestBody.getAlbum(), music.getAlbum()));
			music.setArtist(defaultIfBlank(requestBody.getArtist(), music.getArtist()));
			music.setTitle(defaultIfBlank(requestBody.getMusicName(), music.getTitle()));
		}
		music.setSort(requestBody.getSort());
		music.setGmtModified(Date.from(now));
		music.setLinkStatus(linkStatusEnum.getCode());
		this.saveOrUpdate(music);

		musicLinkService.createOrUpdate(music, requestBody.getLinkList());
	}

}
