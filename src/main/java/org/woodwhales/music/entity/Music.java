package org.woodwhales.music.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 音乐表
 * 
 */
@TableName(value= "music")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Music implements Serializable {
    
    private static final long serialVersionUID = 1L;

    /**
     * 音乐表主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 音乐名称标题（音乐名称）
     */
    @TableField(value = "title")
    private String title;

    /**
     * 音乐封面
     */
    @TableField(value = "cover_url")
    private String coverUrl;

    /**
     * 音乐链接地址
     */
    @TableField(value = "audio_url")
    private String audioUrl;

    /**
     * 作者
     */
    @TableField(value = "artist")
    private String artist;

    /**
     * 专辑
     */
    @TableField(value = "album")
    private String album;

    /**
     * 是否删除，0-已启用，1-已停用，2-已删除
     */
    @TableField(value = "stauts")
    private Byte stauts;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_created")
    private java.util.Date gmtCreated;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private java.util.Date gmtModified;

}