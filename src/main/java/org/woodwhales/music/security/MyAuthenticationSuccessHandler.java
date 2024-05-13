package org.woodwhales.music.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * @author woodwhales on 2024-05-13 14:41
 */
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final String forwardUrl;

    /**
     * @param forwardUrl
     */
    public MyAuthenticationSuccessHandler(String forwardUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(forwardUrl), () -> "'" + forwardUrl + "' is not a valid forward URL");
        this.forwardUrl = forwardUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        this.getRedirectStrategy().sendRedirect(request, response, this.forwardUrl);
    }

}
