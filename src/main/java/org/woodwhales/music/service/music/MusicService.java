package org.woodwhales.music.service.music;

import cn.woodwhales.common.model.vo.PageRespVO;
import org.woodwhales.music.controller.param.MusicCreateRequestBody;
import org.woodwhales.music.controller.param.MusicDeleteRequestBody;
import org.woodwhales.music.controller.param.MusicUpdateRequestBody;
import org.woodwhales.music.controller.param.PageMusicQueryRequestParam;
import org.woodwhales.music.model.MusicDetailInfo;
import org.woodwhales.music.model.MusicInfo;
import org.woodwhales.music.model.MusicListInfo;
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
     * @return
     */
    PageRespVO<MusicSimpleInfo> pageMusic(PageMusicQueryRequestParam param);

    /**
     * 根据id查询音乐详情
     * @param id
     * @return
     */
    MusicDetailInfo getMusicDetailInfoById(Long id);

    /**
     * 删除音乐
     * @param requestBody
     * @return
     */
    boolean deleteMusic(MusicDeleteRequestBody requestBody);

    /**
     * 更新音乐
     * @param requestBody
     * @return
     */
    boolean updateMusic(MusicUpdateRequestBody requestBody);

    /**
     * 导出音乐清单
     * @return
     */
    MusicListInfo exportMusic();
}
