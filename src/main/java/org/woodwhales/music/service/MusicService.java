package org.woodwhales.music.service;

import java.util.List;

import org.woodwhales.music.controller.param.MusicCreateRequestBody;
import org.woodwhales.music.model.MusicInfo;

/**
 * 音乐接口
 * @author woodwhales
 */
public interface MusicService {

    /**
     * list music
     * @return
     */
    List<MusicInfo> listMusic();

    /**
     * save music
     * @param requestBody
     * @return
     */
	boolean createMusic(MusicCreateRequestBody requestBody);
	
	// update music
	
	// delete music
	
}
