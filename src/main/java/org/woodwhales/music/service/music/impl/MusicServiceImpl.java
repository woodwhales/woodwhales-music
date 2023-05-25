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
import org.woodwhales.music.entity.MusicInfo;
import org.woodwhales.music.entity.MusicInfoLink;
import org.woodwhales.music.enums.LinkStatusEnum;
import org.woodwhales.music.enums.MusicLinkSourceEnum;
import org.woodwhales.music.enums.MusicLinkTypeEnum;
import org.woodwhales.music.enums.StatusEnum;
import org.woodwhales.music.mapper.MusicInfoMapper;
import org.woodwhales.music.model.*;

import java.time.Instant;
import java.util.*;

import static org.apache.commons.collections4.CollectionUtils.size;
import static org.apache.commons.lang3.StringUtils.defaultIfBlank;

/**
 * 音乐接口实现类
 * @author woodwhales
 */
@Slf4j
@Primary
@Service
@Transactional(rollbackFor = Exception.class)
public class MusicServiceImpl extends ServiceImpl<MusicInfoMapper, MusicInfo> {
	
	@Autowired
	private MusicInfoMapper musicInfoMapper;

	@Autowired
	private MusicLinkServiceImpl musicLinkService;

    public List<MusicInfoVo> listMusic() {
		List<MusicInfo> musicList = musicInfoMapper.selectList(Wrappers.<MusicInfo>lambdaQuery()
																.orderByAsc(MusicInfo::getStatus)
																.orderByAsc(MusicInfo::getSort)
																.orderByDesc(MusicInfo::getGmtModified));
		MusicInfoLinkContext musicInfoLinkContext = new MusicInfoLinkContext(musicList);
		return DataTool.filter(DataTool.toList(musicList,
								music -> LinkStatusEnum.LINKED.match(music.getLinkStatus()),
								music -> this.convert(music, musicInfoLinkContext)), music -> StringUtils.isNotBlank(music.getAudioUrl()));
    }

	public LayuiPageVO<MusicSimpleInfo> pageMusic(PageMusicQueryRequestParam param) {
		IPage<MusicInfo> page = PageUtil.buildPage(param);
		LambdaQueryWrapper<MusicInfo> wrapper = Wrappers.lambdaQuery();
		wrapper.and(StringUtils.isNotBlank(param.getSearchInfo()),
						i -> i.like(MusicInfo::getTitle, param.getSearchInfo())
								.or()
								.like(MusicInfo::getArtist, param.getSearchInfo())
								.or()
								.like(MusicInfo::getAlbum, param.getSearchInfo()))
				.and(i -> i.eq(MusicInfo::getStatus, StatusEnum.DEFAULT.code))
				.orderByAsc(MusicInfo::getSort);
		IPage<MusicInfo> pageResult = musicInfoMapper.selectPage(page, wrapper);
		MusicInfoLinkContext musicInfoLinkContext = new MusicInfoLinkContext(pageResult.getRecords());
		return LayuiPageVO.build(pageResult, musicInfo -> this.convertSimpleInfo(musicInfo, musicInfoLinkContext), MusicSimpleInfo::compare);
	}

	public MusicDetailInfo getMusicDetailInfoById(Long id) {
		MusicInfo musicInfo = getMusicById(id);
		if(Objects.isNull(musicInfo)) {
			throw new RuntimeException("要访问的数据不存在");
		}
		MusicDetailInfo musicDetailInfo = new MusicDetailInfo();
		BeanUtils.copyProperties(musicInfo, musicDetailInfo);
		List<MusicInfoLinkDetailVo> linkList = musicLinkService.getLinkDetailVoListByMusicId(musicInfo.getId());
		musicDetailInfo.setLinkList(linkList);
		return musicDetailInfo;
	}

	public List<MusicInfoLinkDetailVo> getLinkList() {
		return musicLinkService.getLinkDetailVoListByMusicId(null);
	}

	private MusicInfo getMusicById(Long id) {
		Objects.requireNonNull(id, "不允许请求id为空");
		return musicInfoMapper.selectById(id);
	}

	public boolean deleteMusic(MusicDeleteRequestBody requestBody) {
		Long id = requestBody.getId();
		MusicInfo musicInfo = this.getMusicById(id);
		if(Objects.isNull(musicInfo)) {
			throw new RuntimeException("要删除的数据不存在");
		}
		this.removeById(musicInfo.getId());
		musicLinkService.remove(Wrappers.<MusicInfoLink>lambdaQuery()
				.eq(MusicInfoLink::getMusicId, musicInfo.getId()));
		return true;
	}

    public MusicListInfo exportMusic() {
		List<MusicInfoVo> musicInfoVoList = listMusic();
		if(CollectionUtils.isEmpty(musicInfoVoList)) {
			return new MusicListInfo(size(musicInfoVoList), StringUtils.EMPTY, 50);
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
		return new MusicListInfo(size(musicInfoVoList), stringBuilder.toString(), musicInfoVoList.size() + 3);
    }

	private MusicSimpleInfo convertSimpleInfo(MusicInfo musicInfo, MusicInfoLinkContext musicInfoLinkContext) {
		MusicSimpleInfo musicSimpleInfo = new MusicSimpleInfo();
		BeanUtils.copyProperties(musicInfo, musicSimpleInfo);
		musicSimpleInfo.setAudioUrl(musicInfoLinkContext.getAudioUrl(musicInfo.getId()));
		musicSimpleInfo.setCoverUrl(musicInfoLinkContext.getCoverUrl(musicInfo.getId()));
		musicSimpleInfo.setLinked(LinkStatusEnum.LINKED.match(musicInfo.getLinkStatus()));
		if(StringUtils.isBlank(musicSimpleInfo.getAudioUrl())) {
			musicSimpleInfo.setLinked(false);
		}
		return musicSimpleInfo;
	}

	private MusicInfoVo convert(MusicInfo music, MusicInfoLinkContext musicInfoLinkContext) {
		MusicInfoVo musicInfoVo = new MusicInfoVo();
    	musicInfoVo.setAlbum(music.getAlbum());
    	musicInfoVo.setArtist(music.getArtist());
    	musicInfoVo.setCoverUrl(musicInfoLinkContext.getCoverUrl(music.getId()));
    	musicInfoVo.setAudioUrl(musicInfoLinkContext.getAudioUrl(music.getId()));
    	musicInfoVo.setTitle(music.getTitle());
    	return musicInfoVo;
    }

	/**
	 * 洗旧music数据至 music_info 和 music_info_link
	 */
	public void washMusicToMusicInfo() {
		List<MusicInfo> musicList = this.list();
		List<MusicInfoLink> linkList = new ArrayList<>();
		for (MusicInfo music : musicList) {
			MusicInfoLink audioLink = musicLinkService.getOne(Wrappers.<MusicInfoLink>lambdaQuery()
					.eq(MusicInfoLink::getMusicId, music.getId())
					.eq(MusicInfoLink::getLinkType, MusicLinkTypeEnum.AUDIO_LINK.getCode())
					.eq(MusicInfoLink::getLinkSource, MusicLinkSourceEnum.GITHUB.getCode()));
			if(Objects.isNull(audioLink)) {
				audioLink = new MusicInfoLink();
			}
			audioLink.setMusicId(music.getId());
			audioLink.setLinkType(MusicLinkTypeEnum.AUDIO_LINK.getCode());
			audioLink.setLinkSource(MusicLinkSourceEnum.GITHUB.getCode());
			linkList.add(audioLink);

			MusicInfoLink coverLink = musicLinkService.getOne(Wrappers.<MusicInfoLink>lambdaQuery()
					.eq(MusicInfoLink::getMusicId, music.getId())
					.eq(MusicInfoLink::getLinkType, MusicLinkTypeEnum.COVER_LINK.getCode())
					.eq(MusicInfoLink::getLinkSource, MusicLinkSourceEnum.GITHUB.getCode()));
			if(Objects.isNull(coverLink)) {
				coverLink = new MusicInfoLink();
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
		MusicInfo music;
		Instant now = Instant.now();
		if(Objects.isNull(requestBody.getId())) {
			music = new MusicInfo();
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
