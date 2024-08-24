package org.woodwhales.music.controller.param;

import lombok.Data;

import java.util.List;

/**
 * @author woodwhales on 2024-08-25 0:31
 */
@Data
public class MusicTagListAddRequestBody {

    private Long musicId;

    private List<String> tagNameList;

}
