// package com.dokuku.semi.config;

// import java.util.Optional;

// import org.springframework.web.filter.OncePerRequestFilter;

// import com.dokuku.semi.Repository.LoginRepository;
// import com.dokuku.semi.Service.JwtService;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// public class JwtAuthorizationFilter extends OncePerRequestFilter{
//     private final JwtService jwtService;
//     private final LoginRepository loginRepository;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//         jwtService.extractAccessToken(request)
//                 .filter(jwtService::isTokenValid)
//                 .ifPresentOrElse(
//                         this::saveAuthentication,
//                         () -> checkRefreshToken(request, response)
//                 );
//         filterChain.doFilter(request, response);
//     }

//     private void saveAuthentication(String accessToken) {
//         String email = jwtService.extractUserEmail(accessToken);
//         CustomUser customUser = new CustomUser(loginRepository.findUserByEmail(email).get());
//         UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(customUser, null, customUser.getAuthorities());
//         SecurityContextHolder.getContext().setAuthentication(authentication);
//     }

//     private void checkRefreshToken(HttpServletRequest request, HttpServletResponse response) {
//         Optional<String> refreshToken = jwtService.extractRefreshToken(request)
//                 .filter(jwtService::isTokenValid);

//         if (refreshToken.isPresent()) {
//             User user = loginRepository.findUserByRefreshToken(refreshToken.get())
//                     .orElseThrow(IllegalArgumentException::new);
//             String accessToken = jwtService.createAccessToken(user.getEmail());
//             jwtService.setAccessTokenInHeader(response, accessToken);
//             saveAuthentication(accessToken);
//             return;
//         }
//         throw new IllegalArgumentException("Both tokens are not valid please Login again");
//     }
// }
