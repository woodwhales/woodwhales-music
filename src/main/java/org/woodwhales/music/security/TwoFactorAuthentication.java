package org.woodwhales.music.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 * @author woodwhales on 2024-05-12 22:57
 */
public class TwoFactorAuthentication extends AbstractAuthenticationToken {

    private final Authentication authentication;

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
}
