package com.dokuku.semi.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.dokuku.semi.Service.OAuthService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final OAuthService oAuthService;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .cors()
        .and()
        .csrf().disable()
        .httpBasic().disable()
        .formLogin().disable()
        //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        //.authorizeRequests()
        //.anyRequest().authenticated()
        .authorizeHttpRequests().requestMatchers("/**").permitAll().anyRequest().authenticated()
        //.anyRequest().authenticated();
        .and()
        .oauth2Login()
        .defaultSuccessUrl("/oauth/loginInfo", true)     //OAuth2 성공시 redirect
        .userInfoEndpoint()
        .userService(oAuthService);
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setExposedHeaders(List.of("*"));
        configuration.setAllowedOrigins(List.of("http://localhost:8081","http://localhost:3000"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
