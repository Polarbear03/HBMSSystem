package com.example.model.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.model.entity.User;

import java.util.Collection;
import java.util.List;

@Slf4j
public class SecurityBean implements UserDetails {

    private final User user;

    /**
     * 用于存储权限的List
     */
    private List<SimpleGrantedAuthority> authorities;

    public SecurityBean(User oneUser) {
        this.user = oneUser;
    }

    /**
     * 设置权限的List的set方法
     *
     * @param authorities
     */
    public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    /**
     * 获取用户的信息
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        String password = user.getPassword();
        // 擦除密码，防止泄漏
        user.setPassword(null);
        return password;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getAccountNoExpired().equals(1);
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getAccountNoLocked().equals(1);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getCredentialsNoExpired().equals(1);
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled().equals(1);
    }
}

