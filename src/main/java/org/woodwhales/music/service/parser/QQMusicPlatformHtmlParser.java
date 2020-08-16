package org.woodwhales.music.service.parser;

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
        return document.getElementsByClass("data_info__item data_info__item--even")
                        .get(0)
                        .getElementsByClass("js_album")
                        .get(0)
                        .text();
    }

    @Override
    protected String parseArtist(Document document) {
        return document.getElementsByClass("data__singer").get(0).text();
    }

    @Override
    protected String parseMusicTitle(Document document) {
        return document.getElementsByClass("data__name").get(0).text();
    }
}
