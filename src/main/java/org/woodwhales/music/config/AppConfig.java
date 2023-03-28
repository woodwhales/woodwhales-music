package org.woodwhales.music.config;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.woodwhales.music.enums.MusicLinkSourceEnum;

/**
 * @author woodwhales on 2023-03-28 12:37
 */
@Configuration
@Component
public class AppConfig {

    /**
     * 链接来源：0-github，1-alist
     * @see org.woodwhales.music.enums.MusicLinkSourceEnum
     */
    @Value("${music.link.source}")
    public Integer musicLinkSource;

    public MusicLinkSourceEnum getMusicLinkSourceEnum() {
        return MusicLinkSourceEnum.ofCode(this.musicLinkSource);
    }

    @Bean
    public SpringUtil springUtil() {
        return new SpringUtil();
    }

}
