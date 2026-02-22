package com.example.LeaveService.Exceptions;

import com.example.LeaveService.Entities.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NoSuchLeaveExistsException.class)
    public ResponseEntity<ApiError> handleNoSuchLeaveExists(
            NoSuchLeaveExistsException ex) {

        ApiError error = new ApiError(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,String>> handleRuntimeException(RuntimeException ex){
        Map<String,String> body = new HashMap<>();
        body.put("error", ex.getMessage());
        return ResponseEntity.status(404).body(body);
    }
}
