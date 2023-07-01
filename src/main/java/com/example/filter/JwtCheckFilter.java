package com.example.filter;

import com.example.model.bean.JsonResponse;
import com.example.model.entity.User;
import com.example.util.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class JwtCheckFilter extends OncePerRequestFilter {

    @Resource
    private ObjectMapper objectMapper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/setter/login") || requestURI.equals("/setter/code/getCaptcha")) {
            filterChain.doFilter(request,response);
        } else {
            // 获取请求头中的token，如果为空，则输出错误信息
            String authorization = request.getHeader("Authorization");
            if (!StringUtils.hasText(authorization)) {
                JsonResponse<String> error = JsonResponse.error(450, "token为空", "请返回重新登录");
                printToken(request, response, error);
                return;
            }
            // 将获取的请求头中的jwt token信息，将开头的bearer令牌删除，获取真正的token，检验如果为空，输出错误信息
            String bearer = authorization.replace("bearer ", "");
            if (!StringUtils.hasText(bearer)) {
                JsonResponse<String> error = JsonResponse.error(450, "token为空", "请返回重新登录");
                printToken(request, response, error);
                return;
            }
            // 校验JWT
            boolean verifyToken = JwtUtils.verifyToken(bearer);
            if (!verifyToken) {
                JsonResponse<String> error = JsonResponse.error(451, "token无效", "请返回重新登录");
                printToken(request, response, error);
                return;
            }
            String userInfo = JwtUtils.getUserInfo(bearer);
            List<String> userAuth = JwtUtils.getUserAuth(bearer);
            User user = objectMapper.readValue(userInfo, User.class);
            List<SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();
            userAuth.forEach(uAuth -> {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(uAuth);
                grantedAuthorityList.add(simpleGrantedAuthority);
            });
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, grantedAuthorityList);
            SecurityContextHolder.getContext().setAuthentication(token);
            filterChain.doFilter(request, response);
        }
    }

    private void printToken(HttpServletRequest request, HttpServletResponse response, JsonResponse<String> resultBean) throws IOException {
        String result = objectMapper.writeValueAsString(resultBean);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(result);
        writer.flush();
    }
}


