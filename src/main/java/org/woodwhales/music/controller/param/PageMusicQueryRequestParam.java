package org.woodwhales.music.controller.param;

import lombok.Data;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.9 18:06
 * @description:
 */
@Data
public class PageMusicQueryRequestParam {

    private Integer page;

    private Integer limit;

    private String searchInfo;

}
