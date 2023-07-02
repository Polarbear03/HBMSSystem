package com.example.config.security;

import com.example.config.handler.AppAccessDenyHandler;
import com.example.config.handler.AppLogoutSuccessHandler;
import com.example.config.handler.AuthenticationFailHandler;
import com.example.config.handler.AuthenticationSuccessHandler;
import com.example.filter.JwtCheckFilter;
import com.example.filter.ValidateCodeFilter;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableMethodSecurity
public class WebSecurityConfig {
    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Resource
    private AuthenticationFailHandler authenticationFailHandler;
    @Resource
    private AppAccessDenyHandler appAccessDenyHandler;
    @Resource
    private AppLogoutSuccessHandler appLogoutSuccessHandler;
    @Resource
    private JwtCheckFilter jwtCheckFilter;
    @Resource
    private ValidateCodeFilter validateCodeFilter;

    @Bean
    public SecurityFilterChain setSecurityFilter(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.addFilterBefore(jwtCheckFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/code/getCaptcha")
                .permitAll()
                .requestMatchers("/setter/login")
                .permitAll()
                .anyRequest().authenticated();
        httpSecurity.formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler);
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(appAccessDenyHandler);
        httpSecurity.logout()
                .logoutSuccessHandler(appLogoutSuccessHandler);
        httpSecurity.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder setPwdEncoder() {
        return new BCryptPasswordEncoder();
    }
}

