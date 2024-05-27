package org.woodwhales.music.service.parser;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.woodwhales.music.service.parser.base.BaseMusicPlatformParser;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.16 11:11
 * @description:
 */
@Service
public class XiaMiMusicPlatformParser extends BaseMusicPlatformParser {

    @Override
    protected String parseAlbum(Document document) {
        return document.getElementsByClass("infos")
                        .get(0)
                        .getElementsByClass("info")
                        .get(0)
                        .getElementsByClass("info-value")
                        .get(0).text();
    }

    @Override
    protected String parseArtist(Document document) {
        return document.getElementsByClass("singer-name")
                        .get(0)
                        .text();
    }

    @Override
    protected String parseMusicTitle(Document document) {
        return document.getElementsByClass("titleInfo-name")
                .get(0)
                .text();
    }

    @Override
    protected String parseCoverUrl(Document document) {
        return "";
    }
}
