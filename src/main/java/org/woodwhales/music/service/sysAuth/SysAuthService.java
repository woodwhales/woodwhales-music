package org.woodwhales.music.service.sysAuth;

import cn.woodwhales.common.model.result.OpResult;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.music.controller.param.EnableTwoFactorParam;
import org.woodwhales.music.entity.SysUser;
import org.woodwhales.music.service.sysUser.SysUserService;

/**
 * @author woodwhales on 2024-05-12 20:36
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysAuthService {

    @Autowired
    private SysUserService sysUserService;

    public OpResult<Void> enableTwoFactor(EnableTwoFactorParam param) {
        SysUser authentication = (SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getUsername, authentication.getUsername()));
        sysUser.setTwoFactorEnabled(param.isEnable());
        authentication.setTwoFactorEnabled(param.isEnable());
        sysUserService.saveOrUpdate(sysUser);
        return OpResult.success();
    }
}
