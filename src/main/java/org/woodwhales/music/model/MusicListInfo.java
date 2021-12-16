package org.woodwhales.music.model;

import lombok.Data;

/**
 * @author woodwhales on 2021-12-16 17:54
 */
@Data
public class MusicListInfo {

    private String musicList;

    private int musicListRows;

    public MusicListInfo(String musicList, int musicListRows) {
        this.musicList = musicList;
        this.musicListRows = musicListRows;
    }
}
