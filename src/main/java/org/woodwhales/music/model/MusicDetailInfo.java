package org.woodwhales.music.model;

import lombok.Data;

import java.util.List;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.9 21:40
 * @description:
 */
@Data
public class MusicDetailInfo {

    /**
     * 音乐表主键
     */
    private Integer id;

    /**
     * 音乐名称标题（音乐名称）
     */
    private String title;

    private List<MusicInfoLinkDetailVo> linkList;

    /**
     * 音乐封面
     */
    private String coverUrl;

    /**
     * 音乐链接地址
     */
    private String audioUrl;

    /**
     * 作者
     */
    private String artist;

    /**
     * 专辑
     */
    private String album;

    /**
     * 排序
     */
    private Integer sort;

}
