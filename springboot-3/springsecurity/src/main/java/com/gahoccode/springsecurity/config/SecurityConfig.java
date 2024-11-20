package com.gahoccode.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin((formlogin) -> formlogin.loginProcessingUrl("/login"));
        http.authorizeHttpRequests(req -> req
                .requestMatchers("/auth/login", "/auth/register")
                .permitAll()
                .anyRequest().authenticated());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("admin", "user")
                .build();
        UserDetails user = User
                .withUsername("user")
                .password("user")
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
