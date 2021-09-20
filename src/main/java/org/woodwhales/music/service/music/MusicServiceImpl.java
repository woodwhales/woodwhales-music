package org.woodwhales.music.service.music;

import cn.woodwhales.common.model.util.PageUtil;
import cn.woodwhales.common.model.vo.PageRespVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import org.woodwhales.music.enums.StatusEnum;
import org.woodwhales.music.mapper.MusicMapper;
import org.woodwhales.music.model.MusicDetailInfo;
import org.woodwhales.music.model.MusicInfo;
import org.woodwhales.music.model.MusicSimpleInfo;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;

/**
 * 音乐接口实现类
 * @author woodwhales
 */
@Slf4j
@Primary
@Service("musicServiceImpl")
public class MusicServiceImpl implements MusicService {
	
	@Autowired
	private MusicMapper musicMapper;

    @Override
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

		return musicList.stream()
						.map(this::convert)
						.filter(musicInfo -> !StringUtils.isAnyBlank(musicInfo.getMp3(), musicInfo.getAlbum()))
						.collect(Collectors.toList());
    }
    
    @Override
    public boolean createMusic(MusicCreateRequestBody requestBody) {
		int insert = musicMapper.insert(this.convert(requestBody));
		return insert == 1;
    }

	@Override
	public PageRespVO<MusicSimpleInfo> pageMusic(PageMusicQueryRequestParam param) {
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
		return PageRespVO.buildPageRespVO(pageResult, this::convertSimpleInfo ,MusicSimpleInfo::compare);
	}

	@Override
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

	@Override
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

	@Override
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

		int i = musicMapper.updateById(music);
		return i == 1;
	}

    @Override
    public String exportMusic() {
		List<MusicInfo> musicInfoList = listMusic();
		if(CollectionUtils.isEmpty(musicInfoList)) {
			return StringUtils.EMPTY;
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
		return stringBuilder.toString();
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

	private MusicInfo convert(Music music) {
    	MusicInfo musicInfo = new MusicInfo();
    	musicInfo.setAlbum(music.getAlbum());
    	musicInfo.setArtist(music.getArtist());
    	musicInfo.setCover(music.getCoverUrl());
    	musicInfo.setMp3(music.getAudioUrl());
    	musicInfo.setTitle(music.getTitle());
    	return musicInfo;
    }
}
