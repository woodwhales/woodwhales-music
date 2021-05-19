package org.woodwhales.music.service.music;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.woodwhales.music.model.musicStore.MusicStoreInfo;

import java.util.List;

/**
 * @author woodwhales on 2020-09-29
 * @description
 */
@Service
public class MusicStoreServiceImpl implements MusicStoreService {

    private static List<MusicStoreInfo> musicStore;

    static {
        musicStore = Lists.newArrayList(new MusicStoreInfo("仓库01", "https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store/"),
                new MusicStoreInfo("仓库02", "https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store02/"),
                new MusicStoreInfo("仓库03", "https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store03/"),
                new MusicStoreInfo("仓库04", "https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store04/"));
    }

    @Override
    public List<MusicStoreInfo> getMusicStore() {
        return musicStore;
    }
}
