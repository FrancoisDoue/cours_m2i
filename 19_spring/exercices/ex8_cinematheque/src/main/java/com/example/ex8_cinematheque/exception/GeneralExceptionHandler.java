package com.example.ex8_cinematheque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.DateTimeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GeneralExceptionHandler {

    private ResponseEntity<HashMap<String, String>> createError(Exception ex, HttpStatus status) {
        HashMap<String, String> error = new HashMap<>();
        error.put("status", status.value() + "");
        error.put("reason", status.getReasonPhrase());
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<HashMap<String, String>> handleNotFoundException(NotFoundException e) {
        return createError(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<HashMap<String, String>> handleUnsupportedOperationException(UnsupportedOperationException e) {
        return createError(e, HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<HashMap<String, String>> handleDateTimeException(DateTimeException e) {
        return createError(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Map<String,String>>> handleBindErrors(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errorList = ex.getFieldErrors().stream().map(fieldError -> {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            return errorMap;
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }

}
