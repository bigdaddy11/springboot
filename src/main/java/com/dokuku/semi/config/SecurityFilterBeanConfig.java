// package com.dokuku.semi.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;

// import com.dokuku.semi.Repository.LoginRepository;
// import com.dokuku.semi.Service.JwtService;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import lombok.RequiredArgsConstructor;

// @Configuration
// @RequiredArgsConstructor
// public class SecurityFilterBeanConfig {
//     private final ObjectMapper objectMapper;
//     private final AuthenticationManager authenticationManager;
//     private final JwtService jwtService;
//     private final LoginRepository userRepository;

//     @Bean
//     public JsonLoginProcessFilter jsonLoginProcessFilter(JwtProviderHandler jwtProviderHandler) {
//         JsonLoginProcessFilter jsonLoginProcessFilter = new JsonLoginProcessFilter(objectMapper, authenticationManager);
//         //성공시 JWT 발행
//         jsonLoginProcessFilter.setAuthenticationSuccessHandler(jwtProviderHandler);
//         return jsonLoginProcessFilter;
//     }

//     //client로 부터 받은 jwt 유효성 검사 필터
//     @Bean
//     public JwtAuthorizationFilter jwtAuthorizationFilter() {
//         return new JwtAuthorizationFilter(jwtService, userRepository);
//     }

//     // 로그인 성공 시 JWT 발행
//     @Bean
//     public JwtProviderHandler jwtProviderHandler() {
//         return new JwtProviderHandler(jwtService, userRepository);
//     }
// }
