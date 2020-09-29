package org.woodwhales.music.service.music;

import org.woodwhales.music.model.musicStore.MusicStoreInfo;

import java.util.List;

/**
 * @author woodwhales on 2020-09-29
 * @description 音乐仓库service
 */
public interface MusicStoreService {

    /**
     * 获取所有音乐仓库链接
     * @return
     */
    List<MusicStoreInfo> getMusicStore();

}
