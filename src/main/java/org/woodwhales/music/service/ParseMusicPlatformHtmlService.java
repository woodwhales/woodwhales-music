package org.woodwhales.music.service;

import org.woodwhales.music.model.HtmlContent;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.15 20:03
 * @description:
 */
public interface ParseMusicPlatformHtmlService {

    /**
     * 解析页面
     * @param platformType
     * @param content
     * @return
     */
    HtmlContent parse(String platformType, String content);

}
