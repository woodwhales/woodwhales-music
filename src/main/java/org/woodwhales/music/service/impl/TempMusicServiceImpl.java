package org.woodwhales.music.service.impl;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.woodwhales.music.controller.param.MusicCreateRequestBody;
import org.woodwhales.music.model.MusicInfo;
import org.woodwhales.music.service.MusicService;

import java.util.List;

/**
 * @author woodwhales on 2020-08-04
 * @description
 */
@Service("tempMusicServiceImpl")
public class TempMusicServiceImpl implements MusicService {

    private Gson gson = new Gson();

    @Override
    public List<MusicInfo> listMusic() {
        return gson.fromJson("[{\"title\":\"Someone Like You\",\"artist\":\"Adele\",\"album\":\"Someone Like You\"," +
                "\"cover\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/some_one_like_you.jpg\"," +
                "\"mp3\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/some_one_like_you.m4a\"}," +
                "{\"title\":\"红日\",\"artist\":\"李克勤\",\"album\":\"红日\",\"cover\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/hong_ri.jpg\"," +
                "\"mp3\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/hong_ri.m4a\"}," +
                "{\"title\":\"后来\",\"artist\":\"刘若英\",\"album\":\"我等你\",\"cover\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/hou_lai.jpg\"," +
                "\"mp3\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/hou_lai.mp3\"},{\"title\":\"惊蛰\",\"artist\":\"音阙诗听 / 王梓钰\"," +
                "\"album\":\"二十四节气\",\"cover\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/jing_zhe.jpg\"," +
                "\"mp3\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/jing_zhe.m4a\"}," +
                "{\"title\":\"野狼disco\",\"artist\":\"宝石Gem\",\"album\":\"野狼disco\"," +
                "\"cover\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/ye_lang_disco.jpg\"," +
                "\"mp3\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/ye_lang_disco.m4a\"}," +
                "{\"title\":\"你要相信这不是最后一天\",\"artist\":\"华晨宇\",\"album\":\"你要相信这不是最后一天\"," +
                "\"cover\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002/pic/%E4%BD%A0%E8%A6%81%E7%9B%B8%E4%BF%A1%E8%BF%99%E4%B8%8D%E6%98%AF%E6%9C%80%E5%90%8E%E4%B8%80%E5%A4%A9.jpg\"," +
                "\"mp3\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002/music/%E4%BD%A0%E8%A6%81%E7%9B%B8%E4%BF%A1%E8%BF%99%E4%B8%8D%E6%98%AF%E6%9C%80%E5%90%8E%E4%B8%80%E5%A4%A9.m4a\"},{\"title\":\"光阴的故事\",\"artist\":\"罗大佑\",\"album\":\"光阴的故事\",\"cover\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002/pic/%E5%85%89%E9%98%B4%E7%9A%84%E6%95%85%E4%BA%8B.jpg\",\"mp3\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002/music/%E5%85%89%E9%98%B4%E7%9A%84%E6%95%85%E4%BA%8B.mp3\"},{\"title\":\"蜀绣\",\"artist\":\"李宇春\",\"album\":\"蜀绣\",\"cover\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002/pic/%E8%9C%80%E7%BB%A3.jpg\"," +
                "\"mp3\":\"https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/music/%E8%9C%80%E7%BB%A3.mp3\"}]", new TypeToken<List<MusicInfo>>(){}.getType());
    }

    @Override
    public boolean createMusic(MusicCreateRequestBody requestBody) {
        return false;
    }
}
