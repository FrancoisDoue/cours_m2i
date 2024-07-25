package com.example.better_todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GeneralExceptionHandler {

    private ResponseEntity<HashMap<String, Object>> getExceptionResponseEntity(HttpStatus status, Exception ex) {
        HashMap<String, Object> error = new HashMap<>();
        error.put("status", status.value());
        error.put("details", status.getReasonPhrase());
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HashMap<String, Object>> handleBadCredentialsException(BadCredentialsException ex) {
        return getExceptionResponseEntity(HttpStatus.FORBIDDEN, ex);
    }

//    TODO : NotFound & NotOwner

}
