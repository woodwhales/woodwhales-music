package org.woodwhales.music.controller.param;

import cn.woodwhales.common.model.param.PageQueryParam;
import lombok.Data;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.9 18:06
 * @description:
 */
@Data
public class PageMusicQueryRequestParam extends PageQueryParam {

    private String searchInfo;

}
