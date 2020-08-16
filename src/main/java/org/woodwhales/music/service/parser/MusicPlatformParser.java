package org.woodwhales.music.service.parser;

import org.woodwhales.music.model.HtmlContent;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.15 22:47
 * @description:
 */
public interface MusicPlatformParser {

    /**
     * 解析页面
     * @param platformType
     * @param content
     * @return
     */
    HtmlContent parse(String platformType, String content);
}
