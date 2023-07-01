package com.example.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import java.io.IOException;

@Controller
@Slf4j
public class CaptchaController {
    @GetMapping("/code/getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse servletResponse) throws IOException {
        // 创建出一个图片验证码
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(200,100,4,20);
        // 获取验证码
        String code = circleCaptcha.getCode();
        log.info("生成的图片验证码为：" + code);
        // 将生成的验证码存储到session当中
        request.getSession().setAttribute("CaptchaCode",code);
        ImageIO.write(circleCaptcha.getImage(),"png",servletResponse.getOutputStream());
    }
}
