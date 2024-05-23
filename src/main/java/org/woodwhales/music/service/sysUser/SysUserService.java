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
        String password = systemConfig.getPassword();
        if(StringUtils.isBlank(password)) {
            password = "admin";
        }
        if(Objects.isNull(sysUser)) {
            sysUser = new SysUser();
            sysUser.setUsername("admin");
            sysUser.setPassword(passwordEncoder.encode(password));
            sysUser.setTwoFactorSecret("");
            sysUser.setTwoFactorEnabled(false);
            this.saveOrUpdate(sysUser);
        } else {
            this.update(Wrappers.<SysUser>lambdaUpdate()
                    .eq(SysUser::getId, sysUser.getId())
                    .set(SysUser::getPassword, passwordEncoder.encode(password)));
        }
    }

}
