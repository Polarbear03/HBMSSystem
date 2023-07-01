package com.example.config.security;

import com.example.config.handler.AppAccessDenyHandler;
import com.example.config.handler.AppLogoutSuccessHandler;
import com.example.config.handler.AuthenticationFailHandler;
import com.example.config.handler.AuthenticationSuccessHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
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

    @Bean
    public SecurityFilterChain setSecurityFilter(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        httpSecurity.formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .permitAll();

        httpSecurity.logout().logoutSuccessHandler(appLogoutSuccessHandler);
        httpSecurity.exceptionHandling().accessDeniedHandler(appAccessDenyHandler);

        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder setPwdEncoder() {
        return new BCryptPasswordEncoder();
    }
}
