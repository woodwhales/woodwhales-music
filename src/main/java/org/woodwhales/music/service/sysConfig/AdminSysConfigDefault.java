package org.woodwhales.music.service.sysConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.woodwhales.music.config.AppConfig;

/**
 * @author woodwhales on 2024-05-09 13:48
 */
@Component
public class AdminSysConfigDefault implements SysConfigDefaultFun<AdminSysConfigDefault.Content> {

    public static final String KEY = "admin";

    @Autowired
    private AppConfig appConfig;

    @Override
    public String configKey() {
        return KEY;
    }

    @Override
    public Content defaultConfig() {
        return new Content(appConfig.getMusicSite());
    }

    @Override
    public Class<Content> clazz() {
        return Content.class;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Content {
        private String bannerLinkUrl;
    }
}
