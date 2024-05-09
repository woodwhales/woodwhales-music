package org.woodwhales.music.model;

import lombok.Data;

import java.util.Map;

/**
 * @author woodwhales on 2024-05-09 10:11
 */
@Data
public class SysConfigVo {

    private String configKey;

    private Map<String, Object> content;

}
