package org.woodwhales.music.service.sysConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author woodwhales on 2024-11-01 13:37
 */
@Component
public class VisitSysConfigDefault implements SysConfigDefaultFun<VisitSysConfigDefault.Content> {

    public static final String KEY = "visits";

    @Override
    public String configKey() {
        return KEY;
    }

    @Override
    public Content defaultConfig() {
        return new Content(BigDecimal.ONE);
    }

    @Override
    public Class<Content> clazz() {
        return Content.class;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Content {
        private BigDecimal count;
    }
}
