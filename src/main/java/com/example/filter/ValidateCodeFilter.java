package com.example.filter;

import com.example.model.bean.JsonResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (!requestURI.equals("/setter/login")) {
            filterChain.doFilter(request,response);
        } else {
            validateCode(request,response,filterChain);
        }
    }

    private void validateCode(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String code = request.getParameter("code");
        String captchaCode = (String) request.getSession().getAttribute("CaptchaCode");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        if (!StringUtils.hasText(code)) {
            writer.print(JsonResponse.error(440,"错误","验证码不能为空"));
            return;
        }
        if (!StringUtils.hasText(captchaCode)) {
            writer.print(JsonResponse.error(442,"错误","验证码错误"));
            return;
        }
        if (!code.equalsIgnoreCase(captchaCode)) {
            writer.print(JsonResponse.error(440,"错误","验证码输入错误"));
            return;
        }
        filterChain.doFilter(request,response);
    }
}
