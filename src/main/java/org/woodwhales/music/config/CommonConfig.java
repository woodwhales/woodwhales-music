package org.woodwhales.music.config;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author woodwhales on 2023-12-04 16:32
 */
@Component
public class CommonConfig {

    @Bean
    public SpringUtil springUtil() {
        return new SpringUtil();
    }

}
