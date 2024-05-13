package org.woodwhales.music.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * 参考失败处理器：@see ForwardAuthenticationFailureHandler
 * @author woodwhales
 */
@Slf4j
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final String forwardUrl;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        // TODO 可以增加登录失败统计，锁定指定时间内该IP禁止登录
        log.warn("登录失败");
        this.getRedirectStrategy().sendRedirect(request, response, "/admin/login");
    }

    public MyAuthenticationFailureHandler(String forwardUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(forwardUrl), () -> "'" + forwardUrl + "' is not a valid forward URL");
        this.forwardUrl = forwardUrl;
    }

}
