package com.example.TrainingService.Entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TrainingEmployeeId implements Serializable {
    private Long trainingId;
    private Long employeeId;
}
