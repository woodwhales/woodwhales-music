package org.woodwhales.music.model;

import lombok.Data;

/**
 * @author woodwhales on 2023-03-28 12:02
 */
@Data
public class MusicInfoLinkVo {

    /**
     *
     */
    private String linkUrl;

    /**
     * 链接类型：0-音频，1-封面
     */
    private Integer linkType;

    /**
     * 链接来源：0-github，1-alist
     */
    private Integer linkSource;

}
