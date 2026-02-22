package com.example.UserService.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeesDto {

    @NotBlank(message = "employee number cannot be null or empty")
    @Column(name = "employee_number")
    private Long employeeNumber;

    @NotBlank(message = "first name cannot be null or empty")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "email cannot be null or empty")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String phone;

    @NotBlank(message = "age cannot be null or empty")
    private int age;

    @NotBlank(message = "job title cannot be null or empty")
    private String jobTile;

    @NotBlank(message = "department id cannot be null or empty")
    private Long departmentId;

    @NotBlank(message = "manager id cannot be null or empty")
    private Long managerId;

}
