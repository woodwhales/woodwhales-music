package org.woodwhales.music.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.woodwhales.music.model.HtmlContent;
import org.woodwhales.music.service.MusicPlatformParser;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.15 22:50
 * @description:
 */
@Primary
@Service("WangYiYunMusicPlatformParser")
public class WangYiYunMusicPlatformParser implements MusicPlatformParser {

    @Override
    public HtmlContent parse(String platformType, String content) {
        HtmlContent htmlContent = new HtmlContent();
        htmlContent.setPlatformType(platformType);
        htmlContent.setContent(content);

        Document doc = Jsoup.parseBodyFragment(content);
        Element body = doc.body();

        // 获取标题
        Elements titleElements = body.getElementsByClass("tit");
        htmlContent.setMusicTitle(titleElements.get(0).getElementsByClass("f-ff2").get(0).text());

        // 获取专辑和作者
        Elements elements = doc.getElementsByClass("des s-fc4");
        htmlContent.setArtist(elements.get(0).getElementsByClass("s-fc7").text());
        htmlContent.setAlbum(elements.get(1).getElementsByClass("s-fc7").text());
        
        return htmlContent;
    }
}
