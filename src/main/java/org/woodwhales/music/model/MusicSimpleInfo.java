package org.woodwhales.music.model;

import lombok.Data;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.9 18:18
 * @description:
 */
@Data
public class MusicSimpleInfo {

    /**
     * 音乐表主键
     */
    private Integer id;

    /**
     * 音乐名称标题（音乐名称）
     */
    private String title;

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
     * 是否删除，0-已启用，1-已停用，2-已删除
     */
    private Byte status;

    /**
     * 创建时间
     */
    private java.util.Date gmtCreated;

    /**
     * 更新时间
     */
    private java.util.Date gmtModified;
}
