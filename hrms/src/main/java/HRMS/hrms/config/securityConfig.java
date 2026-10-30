//
//package HRMS.hrms.config;
//
//import HRMS.hrms.auth.repository.authRepo;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.List;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(
//            HttpSecurity http,
//            JwtConfig jwtConfig,
//            authRepo userRepo
//    ) throws Exception {
//
//        http
//                // CORS configuration
////                .cors(cors -> cors.configurationSource(
////                        corsConfigurationSource()
////                ))
//
//                // CSRF configuration
//                .csrf(csrf -> csrf.csrfTokenRepository(
//                        CookieCsrfTokenRepository.withHttpOnlyFalse()
//                ))
//
//                // Session configuration
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(
//                                SessionCreationPolicy.STATELESS
//                        )
//                )
//
//                .formLogin(AbstractHttpConfigurer::disable)
//                .httpBasic(AbstractHttpConfigurer::disable)
//
//                .exceptionHandling(exceptions -> exceptions
//                        .authenticationEntryPoint(
//                                new HttpStatusEntryPoint(
//                                        HttpStatus.UNAUTHORIZED
//                                )
//                        )
//                )
//
//                // Authorization rules
//                .authorizeHttpRequests(auth -> auth
//
//                        // Allow browser CORS preflight requests
//                        .requestMatchers(
//                                HttpMethod.OPTIONS, "/**"
//                        ).permitAll()
//
//                        // Public authentication endpoints
//                        .requestMatchers(
//                                HttpMethod.POST,
//                                "/api/auth/createUser",
//                                "/api/auth/sendOtp",
//                                "/api/auth/validateOtp",
//                                "/api/auth/login"
//                        ).permitAll()
//
//                        // Employee endpoints: ADMIN and HR only
//                        .requestMatchers(
//                                "/api/v1/createEmployee",
//                                "/api/v1/getEmployeeById",
//                                "/api/v1/updateEmployee",
//                                "/api/v1/getAllEmployees",
//                                "/api/v1/getEmployeesByDepartment",
//                                "/api/v1/getEmployeesByDesignation",
//                                "/api/v1/deleteEmployee"
//                        ).hasAnyRole("ADMIN", "HR")
//
//                        // All other endpoints require authentication
//                        .anyRequest().authenticated()
//                )
//
//                // JWT filter
//                .addFilterBefore(
//                        new JwtAuthenticationFilter(
//                                jwtConfig,
//                                userRepo
//                        ),
//                        UsernamePasswordAuthenticationFilter.class
//                );
//
//        return http.build();
//    }
//
////    // CORS configuration bean
////    @Bean
////    public CorsConfigurationSource corsConfigurationSource() {
////
////        CorsConfiguration configuration = new CorsConfiguration();
////
////        configuration.setAllowedOrigins(
////                List.of("http://localhost:5173")
////        );
////
////        configuration.setAllowedMethods(
////                List.of(
////                        "GET",
////                        "POST",
////                        "PUT",
////                        "DELETE",
////                        "PATCH",
////                        "OPTIONS"
////                )
////        );
////
////        configuration.setAllowedHeaders(
////                List.of("*")
////        );
////
////        configuration.setAllowCredentials(true);
////
////        UrlBasedCorsConfigurationSource source =
////                new UrlBasedCorsConfigurationSource();
////
////        source.registerCorsConfiguration(
////                "/**",
////                configuration
////        );
////
////        return source;
////    }
//}








package HRMS.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http
                // Allow frontend requests from browser
                .cors(cors -> cors.configure(http))

                // Disable CSRF for this stateless API
                .csrf(AbstractHttpConfigurer::disable)

                // No server-side session
                .sessionManagement(session -> session
                        .sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)

                // Allow requests without login
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}
