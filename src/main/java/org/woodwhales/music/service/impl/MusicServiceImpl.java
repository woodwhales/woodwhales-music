package org.woodwhales.music.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.woodwhales.music.controller.param.MusicCreateRequestBody;
import org.woodwhales.music.entity.Music;
import org.woodwhales.music.enums.StatusEnum;
import org.woodwhales.music.mapper.MusicMapper;
import org.woodwhales.music.model.MusicInfo;
import org.woodwhales.music.service.MusicService;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 音乐接口实现类
 * @author woodwhales
 */
@Primary
@Service("musicServiceImpl")
public class MusicServiceImpl implements MusicService {
	
	@Autowired
	private MusicMapper musicMapper;

    @Override
    public List<MusicInfo> listMusic() {
    	List<Music> musicList = musicMapper.selectList(null);
    	if(CollectionUtils.isEmpty(musicList)) {
    		return Collections.emptyList();
    	}
    	
    	return musicList.stream().map(this::convert).collect(Collectors.toList());
    }
    
    @Override
    public boolean createMusic(MusicCreateRequestBody requestBody) {
    	int insert = musicMapper.insert(this.convert(requestBody));
    	return insert == 1;
    }
    
    private Music convert(MusicCreateRequestBody requestBody) {
    	Music music = new Music();
    	music.setAlbum(requestBody.getAlbum());
    	music.setArtist(requestBody.getArtist());
    	music.setAudioUrl(requestBody.getAudioUrl());
    	music.setCoverUrl(requestBody.getCoverUrl());
    	music.setTitle(requestBody.getMusicName());
    	music.setStauts(StatusEnum.DEFAULT.code);
    	Instant now = Instant.now();
    	music.setGmtCreated(Date.from(now));
    	music.setGmtModified(Date.from(now));
		return music;
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
