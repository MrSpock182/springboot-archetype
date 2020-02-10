package com.example.demo.interception.implementation;

import com.example.demo.domain.dto.ErrorResponse;
import com.example.demo.domain.dto.builder.ErrorResponseBuilder;
import com.example.demo.exception.InternalServerErrorException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.interception.StackLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.ServiceUnavailableException;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler {

    @Autowired
    private StackLogger stackLogger;

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleInternalServerError(Exception exception, HttpServletRequest request) {
        stackLogger.logger(HttpStatus.INTERNAL_SERVER_ERROR, exception, request);

        return ErrorResponseBuilder.builder()
                .timestamp(new Date())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("INTERNAL SERVER ERROR")
                .message(exception.getMessage())
                .path(request.getServletPath())
                .build();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNotFoundException(Exception exception, HttpServletRequest request) {
        return ErrorResponseBuilder.builder()
                .timestamp(new Date())
                .status(HttpStatus.NOT_FOUND.value())
                .error("NOT FOUND")
                .message(exception.getMessage())
                .path(request.getServletPath())
                .build();
    }
}
