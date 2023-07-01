package com.example.config.handler;

import com.example.model.bean.HttpResult;
import com.example.model.bean.JsonResponse;
import com.example.model.bean.SecurityBean;
import com.example.model.entity.User;
import com.example.util.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * 认证成功处理器
 */
@Component
@Slf4j
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SecurityBean securityBean = (SecurityBean) authentication.getPrincipal();
        User user = securityBean.getUser();
        // 转成JSON字符串
        String stringUserInfo = objectMapper.writeValueAsString(user);

        List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) securityBean.getAuthorities();
        List<String> auths = new ArrayList<>();
        authorities.forEach(authoritie ->{
            auths.add(authoritie.toString());
        });

        String jwtToken = JwtUtils.createJwt(stringUserInfo, auths);
        JsonResponse<String> jwtSuccess = JsonResponse.success(jwtToken);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(jwtSuccess);
        writer.flush();
    }
}

