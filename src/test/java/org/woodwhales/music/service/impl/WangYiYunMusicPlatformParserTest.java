package org.woodwhales.music.service.impl;

import cn.hutool.core.io.FileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import org.woodwhales.music.enums.MusicPlatformTypeEnum;
import org.woodwhales.music.model.HtmlContent;

import java.io.IOException;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.15 20:06
 * @description:
 */
class WangYiYunMusicPlatformParserTest {

    @Test
    public void test() throws IOException {

        String html = FileUtil.readUtf8String(ResourceUtils.getFile("classpath:wang_yi_yun.html"));

        WangYiYunMusicPlatformParser wangYiYunMusicPlatformParser = new WangYiYunMusicPlatformParser();

        HtmlContent htmlContent = wangYiYunMusicPlatformParser.parse(MusicPlatformTypeEnum.WANG_YI_YUN.getPlatform(), html);

        System.out.println(htmlContent);
    }
}