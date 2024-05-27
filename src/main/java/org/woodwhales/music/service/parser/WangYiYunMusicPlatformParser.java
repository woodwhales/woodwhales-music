package org.woodwhales.music.service.parser;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.woodwhales.music.service.parser.base.BaseMusicPlatformParser;

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
        Element element = elements.get(1).getElementsByClass("s-fc7").get(0);
        String album = element.text();

        String subAlbum = null;
        Elements subAlbumElements = elements.get(1).getElementsByClass("s-fc8");
        if(CollectionUtils.isNotEmpty(subAlbumElements)) {
            subAlbum = subAlbumElements.get(0).text();
            subAlbum = StringUtils.trim(subAlbum);
        }
        if(StringUtils.isNotBlank(subAlbum)) {
            album = album + " " + subAlbum;
        }
        return album;
    }

    @Override
    protected String parseArtist(Document document) {
        Elements elements = document.getElementsByClass("des s-fc4");
        return elements.get(0).getElementsByAttribute("title").text();
    }

    @Override
    protected String parseMusicTitle(Document document) {
        Elements titleElements = document.getElementsByClass("tit");
        String title = titleElements.get(0).getElementsByClass("f-ff2").get(0).text();
        // 解析副标题
        String subTitle = null;
        Elements elementsByClass = titleElements.get(0).getElementsByClass("subtit f-fs1 f-ff2");
        if(CollectionUtils.isNotEmpty(elementsByClass)) {
            subTitle = elementsByClass.get(0).text();
        }
        if(StringUtils.isNotBlank(subTitle)) {
            title = title + "(" + subTitle + ")";
        }
        return title;
    }

    @Override
    protected String parseCoverUrl(Document document) {
        return document.getElementsByClass("j-img").get(0).attr("data-src");
    }
}
