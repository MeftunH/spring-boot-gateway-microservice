package com.sha.springbootgatewaymicroservice.Security.jwt;

import com.sha.springbootgatewaymicroservice.Security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {
    String generateToken(UserPrincipal authentication);

    Authentication getAuthentication(HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);
}
