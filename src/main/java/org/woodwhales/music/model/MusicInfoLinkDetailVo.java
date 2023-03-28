package org.woodwhales.music.model;

import lombok.Data;
import org.woodwhales.music.enums.MusicLinkTypeEnum;
import org.woodwhales.music.model.fun.MusicTypeAnnotation;

/**
 * @author woodwhales on 2023-03-28 12:42
 */
@Data
public class MusicInfoLinkDetailVo {
    /**
     * 链接来源：0-github，1-alist
     * @see org.woodwhales.music.enums.MusicLinkSourceEnum
     */
    private Integer linkType;
    /**
     * 链接来源文字描述
     */
    private String linkTypeName;
    /**
     * 封面链接
     */
    @MusicTypeAnnotation(musicLinkType = MusicLinkTypeEnum.COVER_LINK)
    private String coverUrl;
    /**
     * 音频链接
     */
    @MusicTypeAnnotation(musicLinkType = MusicLinkTypeEnum.AUDIO_LINK)
    private String audioUrl;

}
