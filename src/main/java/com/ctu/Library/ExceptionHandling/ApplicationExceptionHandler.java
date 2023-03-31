package com.ctu.Library.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleAuthenticationException(AuthenticationException err){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", "Thông tin đăng nhập không hợp lệ, vui lòng kiểm tra lại tài khoản và mật khẩu");
        return errorMap;
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleCustomException(CustomException err){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", err.getMessage());
        System.out.println(err);
        return new ResponseEntity<>(errorMap, err.getStatusCode());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException err){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", err.getMessage());
        return errorMap;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleUnwantedException(Exception e) {
        e.printStackTrace();
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message","Có lỗi xảy ra, vui lòng thử lại sau");
        return  errorMap;
    }


}
