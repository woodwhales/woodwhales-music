package org.woodwhales.music.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.15 20:04
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HtmlContent {

    private String platformType;

    private String content;

    private String musicTitle;

    private String artist;

    private String album;

    @Override
    public String toString() {
        return "HtmlContent{" +
                "platformType='" + platformType + '\'' +
                ", musicTitle='" + musicTitle + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                '}';
    }
}
