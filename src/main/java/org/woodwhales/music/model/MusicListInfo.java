package org.woodwhales.music.model;

import lombok.Data;

/**
 * @author woodwhales on 2021-12-16 17:54
 */
@Data
public class MusicListInfo {

    /**
     * 收录总量
     */
    private Integer totalCount;

    private String musicList;

    private int musicListRows;

    public MusicListInfo(Integer totalCount, String musicList, int musicListRows) {
        this.totalCount = totalCount;
        this.musicList = musicList;
        this.musicListRows = musicListRows;
    }
}
