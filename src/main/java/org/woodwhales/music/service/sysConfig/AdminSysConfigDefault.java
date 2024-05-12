package org.woodwhales.music.service.sysConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.woodwhales.music.config.AppConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @author woodwhales on 2024-05-09 13:48
 */
@Component
public class AdminSysConfigDefault implements SysConfigDefaultFun {

    @Autowired
    private AppConfig appConfig;

    @Override
    public String configKey() {
        return "admin";
    }

    @Override
    public Map<String, Object> defaultConfig() {
        Map<String, Object> content = new HashMap<>();
        content.put("bannerLinkUrl", appConfig.getMusicSite());
        return content;
    }
}
