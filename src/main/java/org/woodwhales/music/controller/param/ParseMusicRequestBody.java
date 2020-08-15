package org.woodwhales.music.controller.param;

import lombok.Data;
import org.woodwhales.music.enums.MusicPlatformTypeEnum;
import org.woodwhales.music.validation.EnumValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.15 22:33
 * @description:
 */
@Data
public class ParseMusicRequestBody {

    @EnumValidator(target = MusicPlatformTypeEnum.class, message = "非法的要解析的平台请求", method = "getPlatform")
    @NotNull(message = "要解析的平台不允许为空")
    private String platformType;

    @NotBlank(message = "要解析的内容不允许为空")
    private String content;

}
