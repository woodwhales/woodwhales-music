package org.woodwhales.music.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.woodwhales.music.enums.MusicLinkTypeEnum;
import org.woodwhales.music.model.fun.MusicTypeAnnotation;

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

    @MusicTypeAnnotation(musicLinkType = MusicLinkTypeEnum.COVER_LINK)
    private String coverUrl;
    @MusicTypeAnnotation(musicLinkType = MusicLinkTypeEnum.AUDIO_LINK)
    private String audioUrl;
    
    private String ogg;

    public MusicInfo(String title, String artist, String album, String audioUrl, String coverUrl) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.coverUrl = coverUrl;
        this.audioUrl = audioUrl;
    }

}
