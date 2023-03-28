package org.woodwhales.music.enums;

import cn.woodwhales.common.business.DataTool;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;

/**
 * 链接来源：0-github，1-alist
 * @author woodwhales on 2023-03-28 11:56
 */
@AllArgsConstructor
@Getter
public enum MusicLinkSourceEnum {
    /**
     * 0-github
     */
    GITHUB(0, "github"),
    /**
     * 1-alist
     */
    ALIST(1, "alist"),
    ;

    private Integer code;
    private String desc;

    private static Map<Integer, MusicLinkSourceEnum> map = DataTool.enumMap(MusicLinkSourceEnum.class, MusicLinkSourceEnum::getCode);

    public static MusicLinkSourceEnum ofCode(Integer code) {
        return map.get(code);
    }

    public boolean match(Integer code) {
        return Objects.equals(code, this.code);
    }

    public static String getDescByCode(Integer code) {
        return map.get(code).getDesc();
    }

}
