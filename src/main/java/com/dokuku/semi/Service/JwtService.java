package com.dokuku.semi.Service;

import org.springframework.stereotype.Service;

import com.dokuku.semi.Entity.TokenMapping;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class JwtService {

    public Object extractAccessToken(HttpServletRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractAccessToken'");
    }
    // public TokenMapping createToken(String email) {
    //     return TokenMapping.builder()
    //             .accessToken(createAccessToken(email))
    //             .refreshToken(createRefreshToken())
    //             .build();
    // }
}
