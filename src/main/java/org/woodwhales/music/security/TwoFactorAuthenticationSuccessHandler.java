//package org.woodwhales.music.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.woodwhales.music.entity.SysUser;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author woodwhales on 2024-05-12 22:39
// */
//@Slf4j
//public class TwoFactorAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        SysUser sysUser = (SysUser)authentication.getPrincipal();
//        log.info("表单登录成功, authentication={}", authentication);
//        // 开启 2FA
//        if (sysUser.isTwoFactorEnabled()) {
//            TwoFactorAuthentication twoFactorAuthentication = new TwoFactorAuthentication(authentication);
//            SecurityContextHolder.getContext().setAuthentication(twoFactorAuthentication);
//            new SimpleUrlAuthenticationSuccessHandler("/admin/two-factor").onAuthenticationSuccess(request, response, twoFactorAuthentication);
//        } else {
//            new ForwardAuthenticationSuccessHandler("/admin/").onAuthenticationSuccess(request, response, authentication);
//        }
//    }
//
//}
