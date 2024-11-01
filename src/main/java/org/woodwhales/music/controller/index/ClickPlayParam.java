package org.woodwhales.music.controller.index;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author woodwhales on 2024-11-01 23:03
 */
@Data
public class ClickPlayParam {

    @NotNull
    private Long time;

    @NotNull
    private Long id;

}
