package org.woodwhales.music.controller.param;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author woodwhales on 2020-08-10
 * @description
 */
@Data
public class MusicUpdateRequestBody {

    @NotNull(message = "要更新的音乐id不允许为空")
    private Long id;

    @NotBlank(message = "音乐名称不允许为空")
    private String musicName;

    @NotBlank(message = "作者不允许为空")
    private String artist;

    @NotBlank(message = "专辑名称不允许为空")
    private String album;

    private String audioUrl;

    private String coverUrl;

    @Max(value = Integer.MAX_VALUE, message = "排序值不能过大")
    @Min(value = 0, message = "排序值不能小于0")
    private Integer sort = Integer.MAX_VALUE;

    public MusicUpdateRequestBody trim() {
        this.musicName = StringUtils.trim(musicName);
        this.artist = StringUtils.trim(artist);
        this.album = StringUtils.trim(album);
        this.audioUrl = StringUtils.trim(audioUrl);
        this.coverUrl = StringUtils.trim(coverUrl);
        return this;
    }

}
