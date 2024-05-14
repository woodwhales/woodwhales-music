package org.woodwhales.music.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 * @author woodwhales on 2024-05-12 22:57
 */
public class TwoFactorAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 1L;

    private final Authentication authentication;

    /**
     * 创建 Authentication，但是不进行授权成功，即：authenticated = false
     * @param authentication
     */
    public TwoFactorAuthentication(Authentication authentication) {
        super(null);
        this.authentication = authentication;
    }

    @Override
    public Object getCredentials() {
        return this.authentication.getCredentials();
    }

    @Override
    public Object getPrincipal() {
        return this.authentication.getPrincipal();
    }

    public Authentication getAuthentication() {
        return authentication;
    }
}
