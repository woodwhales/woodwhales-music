package org.woodwhales.music.model;

import lombok.Data;

import java.util.Map;

/**
 * @author woodwhales on 2023-03-28 12:42
 */
@Data
public class MusicInfoLinkDetailVo {
    /**
     * 链接来源：0-github，1-alist
     * @see org.woodwhales.music.enums.MusicLinkSourceEnum
     */
    private Integer linkSource;
    /**
     * 链接来源文字描述
     */
    private String linkSourceName;
    /**
     * 链接集合
     */
    Map<String, String> linkMap;

}
