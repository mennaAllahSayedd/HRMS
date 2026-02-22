package com.example.TrainingService.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class EmployeeDto {

    @NotBlank(message = "employee number cannot be null or empty")
    @Column(name = "employee_number")
    private Long employeeNumber;

}
