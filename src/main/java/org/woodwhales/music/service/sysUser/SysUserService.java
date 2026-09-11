package org.woodwhales.music.service.sysUser;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.music.config.SystemConfig;
import org.woodwhales.music.entity.SysUser;
import org.woodwhales.music.mapper.SysUserMapper;

import java.util.Objects;

/**
 * @author woodwhales on 2024-05-12 20:32
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        SysUser sysUser = this.getOne(Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getUsername, "admin"));

        // 仅在首次启动（数据库无 admin 账号）时用 system.init.password 初始化密码；
        // 已有账号后不在启动流程重置，避免「改掉密码后又被自动改回默认值」的问题。
        // 如需重置密码，请在运维侧手工清理 sys_user 表中的 admin 记录，或另外提供后台修改密码入口。
        if(Objects.nonNull(sysUser)) {
            log.info("admin 账号已存在，跳过密码初始化");
            return;
        }

        String password = systemConfig.getPassword();
        if(StringUtils.isBlank(password)) {
            password = "admin";
            log.warn("未配置 system.init.password，使用默认弱密码 'admin'，请尽快登录后台并更换密码");
        }
        String encodePassword = passwordEncoder.encode(password);
        sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser.setPassword(encodePassword);
        sysUser.setTwoFactorSecret("");
        sysUser.setTwoFactorEnabled(false);
        this.saveOrUpdate(sysUser);
        log.info("admin 账号初始化完成");
    }

}
