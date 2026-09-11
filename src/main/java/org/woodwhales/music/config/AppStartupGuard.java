package org.woodwhales.music.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 应用启动安全守卫：在 prod 环境下检测弱凭据并拒绝启动，避免线上裸奔。
 * <p>
 * 检查项：
 * 1. system.init.password（admin 初始密码）不允许为空/弱密码
 * 2. MINIO_ACCESS_KEY / MINIO_SECRET_KEY 不允许为空或常见默认值
 * 3. PG_PASSWORD 不允许为空
 *
 * @author woodwhales
 */
@Slf4j
@Component
public class AppStartupGuard implements ApplicationRunner {

    /**
     * 不允许用于生产的弱密码/默认凭据集合
     */
    private static final List<String> FORBIDDEN_SECRETS = Arrays.asList(
            "", "admin", "password", "123456", "minioadmin", "postgres", "root"
    );

    @Autowired
    private Environment environment;

    @Override
    public void run(ApplicationArguments args) {
        // 只在 prod 环境启用强校验
        if (!environment.acceptsProfiles(Profiles.of("prod"))) {
            log.debug("AppStartupGuard: 非 prod 环境，跳过弱凭据强校验");
            return;
        }

        StringBuilder errors = new StringBuilder();

        // 1. 系统初始化密码
        String initPassword = environment.getProperty("system.init.password");
        checkSecret(errors, "SYSTEM_INIT_PASSWORD", initPassword);

        // 2. 数据库密码
        String pgPassword = environment.getProperty("PG_PASSWORD");
        if (StringUtils.isBlank(pgPassword)) {
            errors.append("\n - PG_PASSWORD 环境变量必须显式设置");
        } else if (FORBIDDEN_SECRETS.contains(pgPassword.toLowerCase())) {
            errors.append("\n - PG_PASSWORD 使用了弱密码: ").append(pgPassword);
        }

        // 3. MinIO 凭据
        String minioAccessKey = environment.getProperty("MINIO_ACCESS_KEY");
        String minioSecretKey = environment.getProperty("MINIO_SECRET_KEY");
        checkSecret(errors, "MINIO_ACCESS_KEY", minioAccessKey);
        checkSecret(errors, "MINIO_SECRET_KEY", minioSecretKey);

        if (errors.length() > 0) {
            String msg = "生产环境检测到弱凭据，拒绝启动：" + errors;
            log.error(msg);
            throw new IllegalStateException(msg);
        }
        log.info("AppStartupGuard: prod 环境凭据检查通过");
    }

    private void checkSecret(StringBuilder errors, String envName, String value) {
        if (StringUtils.isBlank(value)) {
            errors.append("\n - ").append(envName).append(" 必须显式设置，且不允许为空");
            return;
        }
        if (FORBIDDEN_SECRETS.contains(value.toLowerCase())) {
            errors.append("\n - ").append(envName).append(" 使用了弱密码/默认值: ").append(value);
        }
    }

}
