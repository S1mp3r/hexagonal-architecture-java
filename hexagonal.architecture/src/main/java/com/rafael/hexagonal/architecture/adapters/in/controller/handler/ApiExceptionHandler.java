package com.rafael.hexagonal.architecture.adapters.in.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rafael.hexagonal.architecture.application.core.exception.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundExceptionHandler(NotFoundException excep, HttpServletRequest req) {
        var standardError = new StandardError();
        standardError.setTimestamp(System.currentTimeMillis());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setMessage(excep.getMessage());
        standardError.setPath(req.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

}
