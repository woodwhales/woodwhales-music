package org.woodwhales.music.service.parser.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.woodwhales.music.model.HtmlContent;
import org.woodwhales.music.service.parser.MusicPlatformParser;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.16 01:05
 * @description:
 */
public abstract class BaseMusicPlatformParser implements MusicPlatformParser {

    protected abstract String parseAlbum(Document document);

    protected abstract String parseArtist(Document document);

    protected abstract String parseMusicTitle(Document document);

    @Override
    public HtmlContent parse(String platformType, String content) {
        HtmlContent htmlContent = new HtmlContent();
        htmlContent.setPlatformType(platformType);
        htmlContent.setContent(content);

        Document document = Jsoup.parseBodyFragment(content);

        String musicTitle = parseMusicTitle(document);
        htmlContent.setMusicTitle(musicTitle);

        String album = parseAlbum(document);
        htmlContent.setAlbum(album);

        String artist = parseArtist(document);
        htmlContent.setArtist(artist);

        return htmlContent;
    }
}
