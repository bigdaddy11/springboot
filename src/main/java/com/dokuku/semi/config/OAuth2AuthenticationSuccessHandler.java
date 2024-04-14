package com.dokuku.semi.config;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler {
    private static final String TOKEN = "token";
    private static final String REFRESH_TOKEN = "refreshToken";

    //private final JwtService jwtService;
    //private final UserRepository userRepository;
    //private final CustomAuthorizationRequestRepository customAuthorizationRequestRepository;
}
