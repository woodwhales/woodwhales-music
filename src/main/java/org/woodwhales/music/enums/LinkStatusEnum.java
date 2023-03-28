package org.woodwhales.music.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 链接填充状态：0-未填充链接，1-已填充链接
 * @author woodwhales on 2023-03-28 15:35
 */
@AllArgsConstructor
@Getter
public enum LinkStatusEnum {
    /**
     * 0-未填充链接
     */
    UN_LINKED(0, "未填充链接"),

    /**
     * 1-已填充链接
     */
    LINKED(1, "已填充链接"),
    ;
    private Integer code;
    private String desc;

    public boolean match(Integer code) {
        return Objects.equals(code, this.code);
    }

}
