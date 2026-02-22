package com.example.UserService.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DepartmentsDto {

    @NotBlank(message = "department number cannot be null or empty")
    private Long department_Number;

    @NotBlank(message = "department name cannot be null or empty")
    private String name;

    @Size(min = 0, max = 200)
    private String description;
}
