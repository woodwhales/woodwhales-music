package org.woodwhales.music.service.sysConfig.fun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author woodwhales on 2024-11-01 14:04
 */
@Component
public class ClicksSysConfigDefault implements SysConfigDefaultFun<ClicksSysConfigDefault.Content> {

    public static final String KEY = "clicks";

    @Override
    public String configKey() {
        return KEY;
    }

    @Override
    public Content defaultConfig() {
        return new Content(BigDecimal.ONE);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Content {
        private BigDecimal count;
    }
}
