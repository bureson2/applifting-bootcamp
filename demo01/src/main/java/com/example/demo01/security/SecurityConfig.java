package com.example.demo01.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                // allow request without authentication for everything that starts with 'host_url/public/..'
                .antMatchers("/public/**").permitAll()
                .and()
                .authorizeRequests().anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(new KeycloakJwtAuthConverter());
        return http.build();
    }

    // use this config to disable security, comment out the first one
//        @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            http.csrf()
//                    .disable()
//                    .authorizeRequests()
//                    .antMatchers("/**").permitAll()
//                    .and()
//                    .oauth2ResourceServer().jwt().jwtAuthenticationConverter(new KeycloakJwtAuthConverter());
//            return http.build();
//        }

}
