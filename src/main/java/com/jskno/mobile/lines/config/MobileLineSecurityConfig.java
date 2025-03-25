package com.jskno.mobile.lines.config;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher.Builder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableMethodSecurity(securedEnabled=true, prePostEnabled=true)
@EnableWebSecurity
public class MobileLineSecurityConfig {

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new Builder(introspector);
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
//        http
//            .cors(Customizer.withDefaults())
//            .authorizeHttpRequests(authorize -> authorize
//                .requestMatchers(mvc.pattern(HttpMethod.GET, "/v1/users**")).hasAnyAuthority("SCOPE_read", "SCOPE_write")
//                .requestMatchers(mvc.pattern(HttpMethod.POST, "v1/users**")).hasAuthority("SCOPE_write")
//                .requestMatchers(mvc.pattern(HttpMethod.PUT, "v1/users**")).hasAuthority("SCOPE_write")
//                .requestMatchers(mvc.pattern(HttpMethod.DELETE, "v1/users**")).hasAuthority("SCOPE_write")
//                .requestMatchers(mvc.pattern(HttpMethod.POST, "v1/mobile-lines*")).hasAuthority("SCOPE_write")
//                .anyRequest().authenticated())
//            .oauth2ResourceServer(oauthResourceServer -> oauthResourceServer.jwt(Customizer.withDefaults()));
//        return http.build();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
//        http
//            .cors(Customizer.withDefaults())
//            .authorizeHttpRequests(authorize -> authorize
//                .requestMatchers(mvc.pattern(HttpMethod.GET, "/v1/users**")).hasAnyAuthority("SCOPE_mobiles_read", "SCOPE_mobiles_write")
//                .requestMatchers(mvc.pattern(HttpMethod.POST, "v1/users**")).hasAuthority("SCOPE_mobiles_write")
//                .requestMatchers(mvc.pattern(HttpMethod.PUT, "v1/users**")).hasAuthority("SCOPE_mobiles_write")
//                .requestMatchers(mvc.pattern(HttpMethod.DELETE, "v1/users**")).hasAuthority("SCOPE_mobiles_write")
//                .requestMatchers(mvc.pattern(HttpMethod.POST, "v1/mobile-lines*")).hasAuthority("SCOPE_mobiles_write")
//                .anyRequest().authenticated())
//            .oauth2ResourceServer(oauthResourceServer -> oauthResourceServer.jwt(Customizer.withDefaults()));
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());

        http
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(mvc.pattern(HttpMethod.GET, "/v1/users**")).hasRole("mobiles_read")
                .requestMatchers(mvc.pattern(HttpMethod.POST, "v1/users**")).hasRole("mobiles_write")
                .requestMatchers(mvc.pattern(HttpMethod.PUT, "v1/users**")).hasRole("mobiles_write")
//                .requestMatchers(mvc.pattern(HttpMethod.DELETE, "v1/users**")).hasRole("mobiles_delete")
                .requestMatchers(mvc.pattern(HttpMethod.POST, "v1/mobile-lines*")).hasRole("mobiles_write")
                .anyRequest().authenticated())
            .oauth2ResourceServer(oauthResourceServer ->
                oauthResourceServer.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter)));
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(singletonList("http://localhost:8082"));
        configuration.setAllowedOrigins(List.of("http://localhost:8080","http://localhost:8081","http://localhost:8082"));
        configuration.setAllowedMethods(asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(asList(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
