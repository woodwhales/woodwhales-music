package org.woodwhales.music.service.sysAuth;

import cn.woodwhales.common.model.result.OpResult;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.j256.twofactorauth.TimeBasedOneTimePasswordUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.woodwhales.music.controller.param.TwoFactorEnableParam;
import org.woodwhales.music.controller.param.TwoFactorVerifyParam;
import org.woodwhales.music.controller.util.QrCode;
import org.woodwhales.music.entity.SysUser;
import org.woodwhales.music.security.TwoFactorAuthentication;
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

    @Autowired
    private QrCode qrCode;

    public OpResult<String> enableTwoFactor(TwoFactorEnableParam param) {
        SysUser authentication = (SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getUsername, authentication.getUsername()));
        sysUser.setTwoFactorEnabled(param.isEnable());
        authentication.setTwoFactorEnabled(param.isEnable());
        sysUserService.saveOrUpdate(sysUser);
        String imageUrl = "";
        if(sysUser.isEnabled()) {
            String otpAuthUrl = "otpauth://totp/%s?secret=%s&issuer=woodwhales".formatted("woodwhales: " + sysUser.getUsername(),
                    sysUser.getTwoFactorSecret());
            imageUrl = this.qrCode.dataUrl(otpAuthUrl);
        }
        return OpResult.success(imageUrl);
    }

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    public void verify(HttpServletRequest request, HttpServletResponse response,
                       TwoFactorVerifyParam param) throws Exception {
        log.info("param={}", JSON.toJSONString(param));
        String code = param.getCode();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof TwoFactorAuthentication) {
            SysUser sysUser = (SysUser)authentication.getPrincipal();
            try {
                boolean match = TimeBasedOneTimePasswordUtil.validateCurrentNumber(sysUser.getTwoFactorSecret(),
                        StringUtils.hasText(code) ? Integer.parseInt(code) : 0, 10000);
                if (match) {
                    Authentication primaryAuthentication = ((TwoFactorAuthentication) authentication).getAuthentication();
                    SecurityContextHolder.getContext().setAuthentication(primaryAuthentication);
                    new SimpleUrlAuthenticationSuccessHandler("/admin/").onAuthenticationSuccess(request, response, primaryAuthentication);
                    return;
                } else {
                    log.warn("验证码失败");
                    this.authenticationFailureHandler.onAuthenticationFailure(request, response, new BadCredentialsException("Invalid code"));
                    return;
                }
            } catch (Exception e) {
                log.error("验证码异常");
                this.authenticationFailureHandler.onAuthenticationFailure(request, response, new BadCredentialsException("Invalid code"));
                return;
            }
        }
        this.authenticationFailureHandler.onAuthenticationFailure(request, response, new BadCredentialsException("Invalid code"));
    }
}
