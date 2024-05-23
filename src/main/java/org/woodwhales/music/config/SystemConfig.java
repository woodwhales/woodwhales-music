package org.woodwhales.music.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author woodwhales on 2020-08-11
 * @description
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "system.init")
public class SystemConfig {

    private String password;
}
