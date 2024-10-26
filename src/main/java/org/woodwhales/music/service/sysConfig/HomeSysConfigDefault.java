package org.woodwhales.music.service.sysConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.woodwhales.music.config.AppConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author woodwhales on 2024-05-09 13:48
 */
@Component
public class HomeSysConfigDefault implements SysConfigDefaultFun {

    @Autowired
    private AppConfig appConfig;

    @Override
    public String configKey() {
        return "home";
    }

    @Override
    public Map<String, Object> defaultConfig() {
        Map<String, Object> content = new HashMap<>();
        content.put("gitHubCornersShow", appConfig.isGithubShow());
        content.put("gitHubCornersUrl", appConfig.getGithubUrl());
        content.put("authorName", appConfig.getAuthorName());
        content.put("authorWebsite", appConfig.getAuthorWebsite());
        content.put("friendlyInfos", new ArrayList<>());
        return content;
    }
}
