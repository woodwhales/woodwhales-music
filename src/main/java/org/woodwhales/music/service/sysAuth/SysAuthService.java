package org.woodwhales.music.service.sysAuth;

import cn.woodwhales.common.model.result.OpResult;
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
import org.woodwhales.music.controller.param.TwoFactorVerifyParam;
import org.woodwhales.music.controller.result.VerifyErrorRepResult;
import org.woodwhales.music.controller.util.QrCode;
import org.woodwhales.music.entity.SysUser;
import org.woodwhales.music.model.GenerateVo;
import org.woodwhales.music.model.UserMeVo;
import org.woodwhales.music.security.TwoFactorAuthentication;
import org.woodwhales.music.service.sysUser.SysUserService;

import java.security.GeneralSecurityException;

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

    public OpResult<Void> disableTwoFactor() {
        SysUser sysUser = (SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        sysUser.setTwoFactorEnabled(false);
        sysUserService.update(Wrappers.<SysUser>lambdaUpdate()
                        .eq(SysUser::getId, sysUser.getId())
                        .set(SysUser::isTwoFactorEnabled, sysUser.isTwoFactorEnabled()));
        return OpResult.success();
    }

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    public OpResult<Void> enableTwoFactor(TwoFactorVerifyParam param) {
        SysUser sysUser = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String code = param.getCode();
        String tempTwoFactorSecret = sysUser.getTempTwoFactorSecret();
        try {
            if (TimeBasedOneTimePasswordUtil.validateCurrentNumber(tempTwoFactorSecret,
                    StringUtils.hasText(code) ? Integer.parseInt(code) : 0, 10000)) {
                SysUser user = this.sysUserService.getById(sysUser.getId());
                user.setTwoFactorSecret(tempTwoFactorSecret);
                user.setTwoFactorEnabled(true);
                sysUser.setTwoFactorEnabled(true);
                this.sysUserService.update(Wrappers.<SysUser>lambdaUpdate()
                        .eq(SysUser::getId, sysUser.getId())
                        .set(SysUser::getTwoFactorSecret, tempTwoFactorSecret)
                        .set(SysUser::isTwoFactorEnabled, sysUser.isTwoFactorEnabled()));
                return OpResult.success();
            }
        } catch (GeneralSecurityException e) {
            log.error("验证失败, errorMsg={}", e.getMessage(), e);
        }
        return OpResult.failure(new VerifyErrorRepResult());
    }

    public void verify(HttpServletRequest request, HttpServletResponse response,
                       TwoFactorVerifyParam param) throws Exception {
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
                    this.authenticationFailureHandler.onAuthenticationFailure(request, response, new BadCredentialsException("验证码无效"));
                    return;
                }
            } catch (Exception e) {
                log.error("验证码异常");
                this.authenticationFailureHandler.onAuthenticationFailure(request, response, new BadCredentialsException("验证码无效"));
                return;
            }
        }
        this.authenticationFailureHandler.onAuthenticationFailure(request, response, new BadCredentialsException("验证码无效"));
    }

    public OpResult<UserMeVo> userMe() {
        SysUser sysUser = (SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        sysUser = this.sysUserService.getById(sysUser.getId());
        String username = sysUser.getUsername();
        boolean twoFactorEnabled = sysUser.isTwoFactorEnabled();
        UserMeVo vo = new UserMeVo();
        vo.setUsername(username);
        vo.setTwoFactorEnabled(twoFactorEnabled);
        return OpResult.success(vo);
    }

    public OpResult<GenerateVo> generate() {
        SysUser sysUser = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String twoFactorSecret = TimeBasedOneTimePasswordUtil.generateBase32Secret();
        sysUser.setTempTwoFactorSecret(twoFactorSecret);
        String otpAuthUrl = "otpauth://totp/%s?secret=%s&issuer=woodwhales".formatted("woodwhales: " + sysUser.getUsername(), twoFactorSecret);
        GenerateVo generateVo = new GenerateVo();
        generateVo.setTwoFactorSecret(sysUser.getTwoFactorSecret());
        generateVo.setQrCodeUrl(this.qrCode.dataUrl(otpAuthUrl));
        return OpResult.success(generateVo);
    }

}
