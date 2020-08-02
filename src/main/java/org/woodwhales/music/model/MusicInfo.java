package org.woodwhales.music.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MusicInfo {

    private String title;
    
    private String artist;
    
    private String album;
    
    private String cover;
    
    private String mp3;
    
    private String ogg;
}
