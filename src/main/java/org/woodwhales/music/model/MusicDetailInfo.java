package org.woodwhales.music.model;

import lombok.Data;
import org.woodwhales.music.entity.TagInfo;

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
    private Long id;

    /**
     * 音乐名称标题（音乐名称）
     */
    private String title;

    /**
     * 音乐链接集合
     */
    private List<MusicInfoLinkDetailVo> linkList;

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

    /**
     * 标签集合
     */
    private List<TagInfo> tagList;

}
