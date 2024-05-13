package org.woodwhales.music.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import java.util.function.Supplier;

/**
 * @author woodwhales on 2024-05-13 22:03
 */
@Slf4j
public class TwoFactorAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        log.info("TwoFactorAuthorizationManager check: {}", authentication.get() instanceof TwoFactorAuthentication);
        return new AuthorizationDecision(authentication.get() instanceof TwoFactorAuthentication);
    }

}
