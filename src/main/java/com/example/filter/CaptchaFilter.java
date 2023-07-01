package com.example.filter;

import com.example.controller.CaptchaController;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class CaptchaFilter extends OncePerRequestFilter {

    @Resource
    private CaptchaController captchaController;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String captchaEndpoint = "/setter/code/getCaptcha";
        if (request.getRequestURI().equals(captchaEndpoint) && request.getMethod().equals("GET")) {
            CaptchaController.generateCaptcha(request);
        }
        filterChain.doFilter(request, response);
    }
}
