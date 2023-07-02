package com.example.config.handler;

import com.example.model.bean.HttpResult;
import com.example.model.bean.JsonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 访问拒绝处理器
 */
@Component
@Slf4j
public class AppAccessDenyHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        JsonResponse<String> error = JsonResponse.error(403, "没有权限访问", "请联系系统管理员");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charSet=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(error);
        writer.flush();
    }
}

