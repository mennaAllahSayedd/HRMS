package com.example.UserService.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "department_number")
    private Long departmentNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}