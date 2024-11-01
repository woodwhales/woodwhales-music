package org.woodwhales.music.service.sysConfig;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author woodwhales on 2024-11-01 13:37
 */
@Component
public class VisitSysConfigDefault implements SysConfigDefaultFun {

    public static final String KEY = "visits";

    @Override
    public String configKey() {
        return KEY;
    }

    @Override
    public Map<String, Object> defaultConfig() {
        Map<String, Object> content = new HashMap<>();
        content.put("count", BigDecimal.ONE.toString());
        return content;
    }
}
