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
import org.woodwhales.music.controller.param.MusicCreateRequestBody;
import org.woodwhales.music.controller.param.MusicDeleteRequestBody;
import org.woodwhales.music.controller.param.MusicUpdateRequestBody;
import org.woodwhales.music.controller.param.PageMusicQueryRequestParam;
import org.woodwhales.music.entity.Music;
import org.woodwhales.music.entity.MusicLink;
import org.woodwhales.music.enums.MusicLinkSourceEnum;
import org.woodwhales.music.enums.MusicLinkTypeEnum;
import org.woodwhales.music.enums.StatusEnum;
import org.woodwhales.music.mapper.MusicMapper;
import org.woodwhales.music.model.MusicDetailInfo;
import org.woodwhales.music.model.MusicInfo;
import org.woodwhales.music.model.MusicListInfo;
import org.woodwhales.music.model.MusicSimpleInfo;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;

/**
 * 音乐接口实现类
 * @author woodwhales
 */
@Slf4j
@Primary
@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> {
	
	@Autowired
	private MusicMapper musicMapper;

	@Autowired
	private MusicLinkServiceImpl musicLinkService;

    public List<MusicInfo> listMusic() {
		LambdaQueryWrapper<Music> wrapper = Wrappers.lambdaQuery();
		wrapper.ne(Music::getStatus, StatusEnum.DELETE.code)
				.orderByAsc(Music::getStatus)
				.orderByAsc(Music::getSort)
				.orderByDesc(Music::getGmtModified);
		List<Music> musicList = musicMapper.selectList(wrapper);
		if(CollectionUtils.isEmpty(musicList)) {
			return Collections.emptyList();
		}

		List<MusicLink> musicLinkList =  musicLinkService.getLinkInfoListByMusicIds(DataTool.toList(musicList, Music::getId));
		Map<Long, MusicLink> audioUrlMapping = DataTool.toMap(DataTool.filter(musicLinkList,
						musicLink -> MusicLinkTypeEnum.AUDIO_LINK.match(musicLink.getLinkType())),
						MusicLink::getMusicId);
		Map<Long, MusicLink> coverUrlMapping = DataTool.toMap(DataTool.filter(musicLinkList,
						musicLink -> MusicLinkTypeEnum.COVER_LINK.match(musicLink.getLinkType())),
				MusicLink::getMusicId);
		return musicList.stream()
						.map(music -> this.convert(music, audioUrlMapping, coverUrlMapping))
						.filter(musicInfo -> !StringUtils.isAnyBlank(musicInfo.getAudioUrl(), musicInfo.getAlbum()))
						.collect(Collectors.toList());
    }
    
    public boolean createMusic(MusicCreateRequestBody requestBody) {
		int insert = musicMapper.insert(this.convert(requestBody));
		return insert == 1;
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
		return LayuiPageVO.build(pageResult, this::convertSimpleInfo ,MusicSimpleInfo::compare);
	}

	public MusicDetailInfo getMusicDetailInfoById(Long id) {
		Music music = getMusicById(id);
		if(Objects.isNull(music)) {
			throw new RuntimeException("要访问的数据不存在");
		}
		return convertDetailInfo(music);
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

		music.setStatus(StatusEnum.DELETE.code);
		music.setGmtModified(Date.from(Instant.now()));

		int i = musicMapper.updateById(music);
		return i == 1;
	}

	public boolean updateMusic(MusicUpdateRequestBody requestBody) {
		Music music = getMusicById(requestBody.getId());
		if(Objects.isNull(music)) {
			throw new RuntimeException("要更新的数据不存在");
		}

		MusicUpdateRequestBody trimMusicUpdateRequestBody = requestBody.trim();

		music.setAlbum(defaultIfBlank(trimMusicUpdateRequestBody.getAlbum(), music.getAlbum()));
		music.setArtist(defaultIfBlank(trimMusicUpdateRequestBody.getArtist(), music.getArtist()));
		music.setAudioUrl(trimMusicUpdateRequestBody.getAudioUrl());
		music.setCoverUrl(trimMusicUpdateRequestBody.getCoverUrl());
		music.setTitle(defaultIfBlank(trimMusicUpdateRequestBody.getMusicName(), music.getTitle()));
		music.setSort(trimMusicUpdateRequestBody.getSort());
		music.setGmtModified(Date.from(Instant.now()));
		music.setCoverUrl(music.getCoverUrl());
		music.setAudioUrl(music.getAudioUrl());
		int i = musicMapper.updateById(music);
		return i == 1;
	}

    public MusicListInfo exportMusic() {
		List<MusicInfo> musicInfoList = listMusic();
		if(CollectionUtils.isEmpty(musicInfoList)) {
			return new MusicListInfo(StringUtils.EMPTY, 50);
		}
		StringBuilder stringBuilder = new StringBuilder("| 序号 | 音乐名称 | 专辑 | 作者 |\n");
		stringBuilder.append("| --- | ------ | ------ | --- |\n");
		Integer sequenceNo = 1;
		for (MusicInfo musicInfo : musicInfoList) {
			stringBuilder.append(String.format("| %d | %s | %s | %s |\n",
								sequenceNo++,
								StringUtils.isBlank(musicInfo.getTitle()) ? StringUtils.EMPTY : musicInfo.getTitle(),
							  	StringUtils.isBlank(musicInfo.getAlbum()) ? StringUtils.EMPTY : musicInfo.getAlbum(),
							  	StringUtils.isBlank(musicInfo.getArtist()) ? StringUtils.EMPTY : musicInfo.getArtist()));
		}
		return new MusicListInfo(stringBuilder.toString(), musicInfoList.size() + 3);
    }

    private MusicDetailInfo convertDetailInfo(Music music) {
		MusicDetailInfo musicDetailInfo = new MusicDetailInfo();
		BeanUtils.copyProperties(music, musicDetailInfo);
		return musicDetailInfo;
	}

	private Music convert(MusicCreateRequestBody requestBody) {
    	Music music = new Music();
    	music.setAlbum(requestBody.getAlbum());
    	music.setArtist(requestBody.getArtist());
    	music.setAudioUrl(requestBody.getAudioUrl());
    	music.setCoverUrl(requestBody.getCoverUrl());
    	music.setTitle(requestBody.getMusicName());
    	music.setStatus(StatusEnum.DEFAULT.code);
		music.setSort(requestBody.getSort());
    	Instant now = Instant.now();
    	music.setGmtCreated(Date.from(now));
    	music.setGmtModified(Date.from(now));
		music.setCoverUrl(music.getCoverUrl());
		music.setAudioUrl(music.getAudioUrl());
		return music;
	}

	private MusicSimpleInfo convertSimpleInfo(Music music) {
		MusicSimpleInfo musicSimpleInfo = new MusicSimpleInfo();
		BeanUtils.copyProperties(music, musicSimpleInfo);
		if(!StringUtils.isAnyBlank(music.getAudioUrl(), music.getCoverUrl())) {
			musicSimpleInfo.setLinked(true);
		}
		return musicSimpleInfo;
	}

	private MusicInfo convert(Music music, Map<Long, MusicLink> audioUrlMapping, Map<Long, MusicLink> coverUrlMapping) {
    	MusicInfo musicInfo = new MusicInfo();
    	musicInfo.setAlbum(music.getAlbum());
    	musicInfo.setArtist(music.getArtist());
    	musicInfo.setCoverUrl(coverUrlMapping.get(music.getId()).getLinkUrl());
    	musicInfo.setAudioUrl(audioUrlMapping.get(music.getId()).getLinkUrl());
    	musicInfo.setTitle(music.getTitle());
    	return musicInfo;
    }

	public void washLink() {
		List<Music> musicList = this.list();
		List<MusicLink> linkList = new ArrayList<>();
		for (Music music : musicList) {
			MusicLink audioLink = new MusicLink();
			audioLink.setMusicId(music.getId());
			audioLink.setLinkType(MusicLinkTypeEnum.AUDIO_LINK.getCode());
			audioLink.setLinkSource(MusicLinkSourceEnum.GITHUB.getCode());
			audioLink.setLinkUrl(music.getAudioUrl());
			linkList.add(audioLink);

			MusicLink coverLink = new MusicLink();
			coverLink.setMusicId(music.getId());
			coverLink.setLinkType(MusicLinkTypeEnum.COVER_LINK.getCode());
			coverLink.setLinkSource(MusicLinkSourceEnum.GITHUB.getCode());
			coverLink.setLinkUrl(music.getCoverUrl());
			linkList.add(coverLink);
		}
		musicLinkService.saveBatch(linkList);
	}
}
