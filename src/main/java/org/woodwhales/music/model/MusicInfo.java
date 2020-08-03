package org.woodwhales.music.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 音乐对象
 * @author woodwhales
 */
@Data
@NoArgsConstructor
public class MusicInfo {

    private String title;
    
    private String artist;
    
    private String album;
    
    private String cover;
    
    private String mp3;
    
    private String ogg;

    public MusicInfo(String title, String artist, String album, String mp3, String cover) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.cover = cover;
        this.mp3 = mp3;
    }
}
