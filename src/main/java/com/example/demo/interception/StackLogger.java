package com.example.demo.interception;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

public interface StackLogger {
    void logger(HttpStatus httpStatus, Exception exception, HttpServletRequest request);
}
