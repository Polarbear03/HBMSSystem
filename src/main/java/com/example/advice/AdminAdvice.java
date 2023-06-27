package com.example.advice;

import com.example.exception.AdminFormatException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdminAdvice {
    @ExceptionHandler(AdminFormatException.class)
    public ErrorResponse outAdminError() {
        return null;
    }


}
