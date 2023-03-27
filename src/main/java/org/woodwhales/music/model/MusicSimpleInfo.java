package org.woodwhales.music.model;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
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
     * 是否已关联音乐链接
     */
    private Boolean linked;

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
     * 音乐链接
     */
    private String audioUrl;

    /**
     * 创建时间
     */
    private java.util.Date gmtCreated;

    /**
     * 更新时间
     */
    private java.util.Date gmtModified;

    public int compare(MusicSimpleInfo musicSimpleInfo) {
        return ComparisonChain.start()
                .compare(this.sort, musicSimpleInfo.getSort())
                .compare(this.gmtModified, musicSimpleInfo.getGmtModified(), Ordering.natural().reverse())
                .result();
    }
}
