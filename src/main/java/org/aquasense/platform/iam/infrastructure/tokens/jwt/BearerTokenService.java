package org.aquasense.platform.iam.infrastructure.tokens.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.aquasense.platform.iam.application.internal.outboundservices.tokens.TokenService;
import org.springframework.security.core.Authentication;

public interface BearerTokenService extends TokenService {

    String getBearerTokenFrom(HttpServletRequest request);

    String generateToken(Authentication authentication);
}
