package com.example.advice;

import com.example.model.bean.JsonResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestControllerAdvice(basePackages = "com.example.controller")
public class AdminAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public JsonResponse<Map<String,Object>> outAdminError(MethodArgumentNotValidException bindException) {
        Map<String,Object> errorMap = new HashMap<>();
        BindingResult bindingResult = bindException.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            fieldErrors.forEach(fieldError -> {
                errorMap.put("错误[" + fieldError.getField() + "] 原因",fieldError.getDefaultMessage());
            });
        }
        return JsonResponse.error(errorMap);
    }


}
