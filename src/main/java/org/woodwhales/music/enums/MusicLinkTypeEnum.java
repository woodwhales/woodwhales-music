package org.woodwhales.music.enums;

import cn.woodwhales.common.business.DataTool;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;

/**
 * 链接类型：0-音频，1-封面
 * @author woodwhales on 2023-03-28 11:54
 */
@AllArgsConstructor
@Getter
public enum MusicLinkTypeEnum {
    /**
     * 0-音频
     */
    AUDIO_LINK(0, "音频"),
    /**
     * 1-封面
     */
    COVER_LINK(1, "封面"),
    ;

    private Integer code;
    private String desc;

    private static Map<Integer, MusicLinkTypeEnum> map = DataTool.enumMap(MusicLinkTypeEnum.class, MusicLinkTypeEnum::getCode);

    public boolean match(Integer code) {
        return Objects.equals(code, this.code);
    }

    public static MusicLinkTypeEnum ofCode(Integer code) {
        return map.get(code);
    }

}
