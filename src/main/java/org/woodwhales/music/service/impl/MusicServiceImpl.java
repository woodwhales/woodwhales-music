package org.woodwhales.music.service.impl;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.woodwhales.music.model.MusicInfo;
import org.woodwhales.music.service.MusicService;

import java.util.ArrayList;
import java.util.List;

/**
 * 音乐接口实现类
 * @author woodwhales
 */
@Service
public class MusicServiceImpl implements MusicService {

    private final String commonsMusicCDN = "https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/";

    private final String commonsCoverCDN = "https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/";

    @Override
    public List<MusicInfo> listMusicInfos() {


        ArrayList<MusicInfo> list = Lists.newArrayListWithCapacity(16);

        list.add(new MusicInfo("Someone Like You", "Adele", "Someone Like You", commonsMusicCDN + "some_one_like_you.m4a", commonsCoverCDN + "some_one_like_you.jpg"));
        list.add(new MusicInfo("红日", "李克勤", "红日", commonsMusicCDN + "hong_ri.m4a", commonsCoverCDN + "hong_ri.jpg"));
        list.add(new MusicInfo("后来", "刘若英", "后来", commonsMusicCDN + "hou_lai.mp3", commonsCoverCDN + "hou_lai.jpg"));
        list.add(new MusicInfo("惊蛰", "音阙诗听/王梓钰", "惊蛰", commonsMusicCDN + "jing_zhe.m4a", commonsCoverCDN + "jing_zhe.jpg"));
        list.add(new MusicInfo("野狼disco", "宝石gem", "野狼disco", commonsMusicCDN + "ye_lang_disco.m4a", commonsCoverCDN + "ye_lang_disco.jpg"));
        return list;
    }
}
