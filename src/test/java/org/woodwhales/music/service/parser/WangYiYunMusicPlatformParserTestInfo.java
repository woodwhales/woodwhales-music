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
 * @date: 20.8.16 12:53
 * @description:
 */
class WangYiYunMusicPlatformParserTestInfo {

    @Test
    public void test() throws IOException {

        String html = FileUtil.readUtf8String(ResourceUtils.getFile("classpath:wang_yi_yun.html"));

        MusicPlatformParser musicPlatformParser = new WangYiYunMusicPlatformParser();

        HtmlContent htmlContent = musicPlatformParser.parse(MusicPlatformTypeEnum.WANG_YI_YUN.getPlatform(), html);

        System.out.println(htmlContent);
    }

}