package com.example.config.handler;

import com.example.model.bean.HttpResult;
import com.example.model.bean.JsonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * 登出成功处理器
 */
@Component
@Slf4j
public class AppLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        JsonResponse<String> error = JsonResponse.error(200, "退出成功", "退出系统成功");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charSet=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(error);
        writer.flush();
    }
}

