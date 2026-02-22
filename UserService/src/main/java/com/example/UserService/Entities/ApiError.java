package com.example.UserService.Entities;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
public class ApiError {
    private int status;
    private String message;
    private LocalDateTime timestamp;

}
