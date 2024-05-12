package org.woodwhales.music.service.sysUser;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.j256.twofactorauth.TimeBasedOneTimePasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.music.config.SystemConfig;
import org.woodwhales.music.entity.SysUser;
import org.woodwhales.music.mapper.SysUserMapper;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {
        SysUser sysUser = this.getOne(Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getUsername, systemConfig.getUsername()));
        if(Objects.isNull(sysUser)) {
            sysUser = new SysUser();
            sysUser.setUsername(systemConfig.getUsername());
            sysUser.setPassword(systemConfig.getPassword());
            sysUser.setTwoFactorSecret(TimeBasedOneTimePasswordUtil.generateBase32Secret());
            sysUser.setTwoFactorEnabled(false);
            this.saveOrUpdate(sysUser);
        }
    }


}
