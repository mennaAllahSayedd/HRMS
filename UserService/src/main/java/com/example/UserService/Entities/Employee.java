package com.example.UserService.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_number", unique = true)
    private Long employeeNumber;

    @NotBlank(message = "first name cannot be null or empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "age")
    private int age;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "job_title")
    private String jobTile;

    @Column(name="user_id")
    private Long userId;

    @Column(name = "manager_id")
    private Long managerId;

}
