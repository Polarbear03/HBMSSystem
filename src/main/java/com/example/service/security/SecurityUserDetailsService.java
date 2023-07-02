package com.example.service.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.SecurityBean;
import com.example.model.entity.User;
import com.example.service.inter.PermissionService;
import com.example.service.inter.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SecurityUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Resource
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null) {
            throw new UsernameNotFoundException("该用户未找到");
        }
        User user = userService.getUserByUserName(username);

        // 用户权限集合
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        // 查询该用户的权限集合
        List<String> permissionByUserId = permissionService.queryPermissionByUserId(user.getUserId());
        permissionByUserId.forEach(permission -> {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(permission);
            simpleGrantedAuthorities.add(simpleGrantedAuthority);
        });
        SecurityBean securityBean = new SecurityBean(user);

        securityBean.setAuthorities(simpleGrantedAuthorities);
        return securityBean;
    }

}
