package org.woodwhales.music.service.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.woodwhales.music.service.base.BaseMusicPlatformParser;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.15 22:50
 * @description:
 */
@Primary
@Service("WangYiYunMusicPlatformParser")
public class WangYiYunMusicPlatformParser extends BaseMusicPlatformParser {

    @Override
    protected String parseAlbum(Document document) {
        Elements elements = document.getElementsByClass("des s-fc4");
        return elements.get(1).getElementsByClass("s-fc7").text();
    }

    @Override
    protected String parseArtist(Document document) {
        Elements elements = document.getElementsByClass("des s-fc4");
        return elements.get(0).getElementsByClass("s-fc7").text();
    }

    @Override
    protected String parseMusicTitle(Document document) {
        Elements titleElements = document.getElementsByClass("tit");
        return titleElements.get(0).getElementsByClass("f-ff2").get(0).text();
    }
}
