package org.woodwhales.music.service.sysConfig.fun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author woodwhales on 2025-03-25 10:24
 */
@Component
public class RebotsSysConfigDefault implements SysConfigDefaultFun<RebotsSysConfigDefault.Content> {

    public static final String KEY = "robots";

    @Override
    public String configKey() {
        return KEY;
    }

    @Override
    public Content defaultConfig() {
        return new Content();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Content {
        private String robots = "";
    }

}
