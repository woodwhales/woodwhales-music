package org.woodwhales.music.controller.param;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author woodwhales on 2024-05-09 10:11
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysConfigGetRequestBody {

    @NotBlank(message = "configKey不允许为空")
    private String configKey;

}
