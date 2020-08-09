package org.woodwhales.music.service;

import org.woodwhales.music.controller.param.MusicCreateRequestBody;
import org.woodwhales.music.controller.param.PageMusicQueryRequestParam;
import org.woodwhales.music.controller.resp.PageBaseVO;
import org.woodwhales.music.model.MusicDetailInfo;
import org.woodwhales.music.model.MusicInfo;
import org.woodwhales.music.model.MusicSimpleInfo;

import java.util.List;

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

    /**
     * 分页查询
     * @param param
     */
    PageBaseVO<List<MusicSimpleInfo>> pageMusic(PageMusicQueryRequestParam param);

    /**
     * 根据id查询音乐详情
     * @param id
     * @return
     */
    MusicDetailInfo getMusicById(Long id);

    // update music
	
	// delete music
	
}
