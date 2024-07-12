package com.example.ex9_employee_back.exception;

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

    public static ResponseEntity<HashMap<String, String>> getHashMapResponseEntity(Exception ex, HttpStatus status) {
        HashMap<String, String> error = new HashMap<>();
        error.put("status", status.value() + "");
        error.put("reason", status.getReasonPhrase());
        error.put("message", "子曰 : " + ex.getMessage());
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<HashMap<String, String>> handleAuthenticationFailedException(AuthenticationFailedException ex) {
        return getHashMapResponseEntity(ex, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<HashMap<String, String>> handleNotFoundException(NotFoundException e) {
        return getHashMapResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<HashMap<String, String>> handleUnsupportedOperationException(UnsupportedOperationException e) {
        return getHashMapResponseEntity(e, HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler({DateTimeException.class, FailedConversionException.class})
    public ResponseEntity<HashMap<String, String>> handleDateTimeException(DateTimeException e) {
        return getHashMapResponseEntity(e, HttpStatus.BAD_REQUEST);
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
