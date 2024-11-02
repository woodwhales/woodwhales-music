package org.woodwhales.music.service.sysConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.woodwhales.music.config.AppConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @author woodwhales on 2024-05-09 13:48
 */
@Component
public class HomeSysConfigDefault implements SysConfigDefaultFun<HomeSysConfigDefault.Content> {

    public static final String KEY = "home";

    @Autowired
    private AppConfig appConfig;

    @Override
    public String configKey() {
        return KEY;
    }

    @Override
    public Class<Content> clazz() {
        return Content.class;
    }

    @Override
    public Content defaultConfig() {
        Content content = new Content();
        content.setGitHubCornersShow(appConfig.isGithubShow());
        content.setGitHubCornersUrl(appConfig.getGithubUrl());
        content.setAuthorName(appConfig.getAuthorName());
        content.setAuthorWebsite(appConfig.getAuthorWebsite());
        content.setFriendlyInfos(new ArrayList<>());
        return content;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Content {
        private boolean gitHubCornersShow;
        private String gitHubCornersUrl;
        private String authorName;
        private String authorWebsite;
        private List<Friendly> friendlyInfos;
    }

    @Data
    public static class Friendly {
        private String name;
        private String url;
    }
}
