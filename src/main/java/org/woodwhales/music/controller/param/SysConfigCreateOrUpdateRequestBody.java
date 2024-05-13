package org.woodwhales.music.controller.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;

/**
 * @author woodwhales on 2024-05-08 17:37
 */
@Data
public class SysConfigCreateOrUpdateRequestBody {

    @NotBlank(message = "configKey不允许为空")
    private String configKey;

    @NotNull(message = "配置内容不允许为空")
    private Map<String, Object> content;

}
