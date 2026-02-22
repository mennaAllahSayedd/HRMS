package com.example.UserService.Exceptions;

import com.example.UserService.Entities.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j

public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleEmployeeAlreadyExists(
            EmployeeAlreadyExistsException ex) {

        ApiError error = new ApiError(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        log.warn("Employee Already Exist" );

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NoSuchEmployeeExistsException.class)
    public ResponseEntity<ApiError> handleNoSuchEmployeeExists(
            EmployeeAlreadyExistsException ex) {

        ApiError error = new ApiError(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );

        log.error("Employee Not Found" );

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
