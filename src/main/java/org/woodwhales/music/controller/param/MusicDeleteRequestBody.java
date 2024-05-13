package org.woodwhales.music.controller.param;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author woodwhales on 2020-08-10
 * @description
 */
@Data
public class MusicDeleteRequestBody {

    @NotNull(message = "要删除的id不允许为空")
    private Long id;

}
