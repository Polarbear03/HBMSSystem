package com.example.config.mvcsetting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
public class WebMVCConfig {

    /**
     * 创建一个超级用户
     * @return
     */
    @Bean
    public UserDetailsService createUserDetailsService() {
        UserDetails superUser = User.builder()
                .username("dingZ302116")
                .password("03302116")
                .roles("superAdmin")
                .authorities("")
                .build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(superUser);
        return inMemoryUserDetailsManager;

    }


    /**
     * 配置密码加密器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
