package com.example.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (!requestURI.equals("/login/doLogin")) {
            filterChain.doFilter(request,response);
        } else {
            validataCode(request,response,filterChain);
        }
    }

    private void validataCode(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String code = request.getParameter("code");
        String captchaCode = (String) request.getSession().getAttribute("CaptchaCode");
        request.getSession().removeAttribute("captchaCodeErrorMsg");
        
        if (!StringUtils.hasText(code)) {
            request.getSession().setAttribute("captchaCodeErrorMsg","验证码不能为空");
            response.sendRedirect("/toLogin");
            return;
        }
        if (!StringUtils.hasText(captchaCode)) {
            request.getSession().setAttribute("captchaCodeErrorMsg","验证码错误");
            response.sendRedirect("/toLogin");
            return;
        }
        if (!code.equalsIgnoreCase(captchaCode)) {
            request.getSession().setAttribute("captchaCodeErrorMsg","验证码输入错误");
            response.sendRedirect("/toLogin");
            return;
        }
        filterChain.doFilter(request,response);
    }
}
