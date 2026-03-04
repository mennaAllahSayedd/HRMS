package com.example.TrainingService.Entities;


import jakarta.persistence.*;

@Entity
public class TrainingEmployee {

    @EmbeddedId
    private TrainingEmployeeId id; // training_id + employee_id

    @ManyToOne
    @MapsId("trainingNum")
    @JoinColumn(name = "training_Num")
    private Training training;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Long employeeId;
}
