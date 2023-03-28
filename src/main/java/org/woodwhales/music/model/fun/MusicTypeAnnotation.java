package org.woodwhales.music.model.fun;

import org.woodwhales.music.enums.MusicLinkTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author woodwhales on 2023-03-28 12:06
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MusicTypeAnnotation {

    /**
     * 音频类型
     * @return
     */
    MusicLinkTypeEnum musicLinkType();

}
