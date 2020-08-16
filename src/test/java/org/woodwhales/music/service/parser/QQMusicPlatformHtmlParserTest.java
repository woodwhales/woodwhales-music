package org.woodwhales.music.service.parser;

import cn.hutool.core.io.FileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import org.woodwhales.music.enums.MusicPlatformTypeEnum;
import org.woodwhales.music.model.HtmlContent;

import java.io.IOException;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.16 13:03
 * @description:
 */
class QQMusicPlatformHtmlParserTest {

    @Test
    public void test() throws IOException {

        String html = FileUtil.readUtf8String(ResourceUtils.getFile("classpath:qq_music.html"));

        MusicPlatformParser musicPlatformParser = new QQMusicPlatformHtmlParser();

        HtmlContent htmlContent = musicPlatformParser.parse(MusicPlatformTypeEnum.QQ_MUSIC.getPlatform(), html);

        System.out.println(htmlContent);
    }

}