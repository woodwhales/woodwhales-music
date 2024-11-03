package org.woodwhales.music.service.sysConfig.fun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.woodwhales.music.config.AppConfig;

/**
 * @author woodwhales on 2024-11-03 9:55
 */
@Component
public class ProductSysConfigDefault implements SysConfigDefaultFun<ProductSysConfigDefault.Content> {

    public static final String KEY = "product";

    @Autowired
    private AppConfig appConfig;

    @Override
    public String configKey() {
        return KEY;
    }

    @Override
    public Content defaultConfig() {
        return new Content(appConfig.getVersion());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Content {
        private String productVersion;
    }

}
