package org.woodwhales.music.service.parser;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.woodwhales.music.service.parser.base.BaseMusicPlatformParser;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.16 01:02
 * @description:
 */
@Service
public class QQMusicPlatformHtmlParser extends BaseMusicPlatformParser {

    @Override
    protected String parseAlbum(Document document) {
        String text = document.getElementsByClass("data__cont")
                              .get(0)
                              .getElementsByClass("data_info__item_song")
                              .get(0)
                              .text();
        return StringUtils.substringAfter(text, "专辑：");
    }

    @Override
    protected String parseArtist(Document document) {
        return document.getElementsByClass("data__singer").get(0).text();
    }

    @Override
    protected String parseMusicTitle(Document document) {
        return document.getElementsByClass("data__name").get(0).text();
    }

    @Override
    protected String parseCoverUrl(Document document) {
        return "https:" + document.getElementsByClass("data__photo").get(0).attr("src");
    }
}
