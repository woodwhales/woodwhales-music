package org.woodwhales.music.service.music.impl;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.woodwhales.music.model.musicStore.MusicStoreInfo;
import org.woodwhales.music.service.music.MusicStoreService;

import java.util.List;

/**
 * @author woodwhales on 2020-09-29
 * @description
 */
@Service
public class MusicStoreServiceImpl implements MusicStoreService {

    private static List<MusicStoreInfo> musicStore;

    static {
        musicStore = Lists.newArrayList(
                new MusicStoreInfo("仓库01", "https://fastly.jsdelivr.net/gh/woodwhales/woodwhales-music-store/"),
                new MusicStoreInfo("仓库02", "https://fastly.jsdelivr.net/gh/woodwhales/woodwhales-music-store02/"),
                new MusicStoreInfo("仓库03", "https://fastly.jsdelivr.net/gh/woodwhales/woodwhales-music-store03/"),
                new MusicStoreInfo("仓库04", "https://fastly.jsdelivr.net/gh/woodwhales/woodwhales-music-store04/"),
                new MusicStoreInfo("仓库05", "https://fastly.jsdelivr.net/gh/woodwhales/woodwhales-music-store05/"),
                new MusicStoreInfo("仓库06", "https://fastly.jsdelivr.net/gh/woodwhales/woodwhales-music-store06/")
        );
    }

    @Override
    public List<MusicStoreInfo> getMusicStore() {
        return musicStore;
    }
}
