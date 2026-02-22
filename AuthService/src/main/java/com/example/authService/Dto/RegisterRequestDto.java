package com.example.authService.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
