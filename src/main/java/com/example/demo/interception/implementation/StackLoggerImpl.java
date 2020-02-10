package com.example.demo.interception.implementation;

import com.example.demo.interception.StackLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.StringJoiner;

@Component
public class StackLoggerImpl implements StackLogger {

    private Logger logger = LoggerFactory.getLogger(StackLoggerImpl.class);

    @Override
    public void logger(HttpStatus httpStatus, Exception exception, HttpServletRequest request) {
        try {
            StringJoiner sj = new StringJoiner("");
            sj.add("---------------- Application Error ----------------" + '\n');
            sj.add(String.format("Status Code: %s", httpStatus) + '\n');
            sj.add(String.format("Request: %s", getBodyRequest(request)) + '\n');
            sj.add(String.format("Path: %s", request.getServletPath()) + '\n');
            sj.add(String.format("Message Error: %s", exception.getMessage()) + '\n');
            sj.add(String.format("Cause: %s", exception.getCause()) + '\n');
            sj.add(String.format("Processors (cores): %s",
                            Runtime.getRuntime().availableProcessors()) + '\n');
            sj.add(String.format("Free memory (bytes): %s",
                            Runtime.getRuntime().freeMemory()) + '\n');
            sj.add("---------------- Stack Trace ----------------" + '\n');
            for (StackTraceElement stack : exception.getStackTrace()) {
                sj.add(String.format("Class: %s", stack.getClassName()) + '\n');
                sj.add(String.format("Method: %s", stack.getMethodName()) + '\n');
                sj.add(String.format("File: %s", stack.getFileName()) + '\n');
                sj.add(String.format("Line Error: %d", stack.getLineNumber()) + '\n');
            }

            logger.error(sj.toString());
        } catch (Exception ex) {
            logger.error(String.format("Erro ao criar registering: %s", ex.getMessage()));
        }
    }

    private String getBodyRequest(HttpServletRequest request) {
        StringBuffer buffer = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception ex) {
            logger.error(String.format("Erro ao retornar request: %s", ex.getMessage()));
        }

        return buffer.toString();
    }

}
