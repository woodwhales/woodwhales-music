package org.woodwhales.music.service.parse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.woodwhales.music.enums.MusicPlatformTypeEnum;
import org.woodwhales.music.model.HtmlContent;
import org.woodwhales.music.service.parser.MusicPlatformParser;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.15 20:06
 * @description:
 */
@Service
public class ParseMusicPlatformHtmlServiceImpl implements ParseMusicPlatformHtmlService {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public HtmlContent parse(String platformType, String content) {
        MusicPlatformTypeEnum musicPlatformTypeEnum = MusicPlatformTypeEnum.ofPlatform(platformType);
        MusicPlatformParser musicPlatformParser = applicationContext.getBean(musicPlatformTypeEnum.getServiceClass());
        return musicPlatformParser.parse(platformType, content);
    }
}
