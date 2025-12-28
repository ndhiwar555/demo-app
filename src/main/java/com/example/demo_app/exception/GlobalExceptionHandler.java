package com.example.demo_app.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = LaptopException.class)
    public ResponseEntity<?> laptopNameException(LaptopException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }



}
