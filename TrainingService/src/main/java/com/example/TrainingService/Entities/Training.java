package com.example.TrainingService.Entities;

import com.example.TrainingService.Enum.TrainingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Training extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "training_Num",nullable = false,unique = true)
    Long trainingNum;

    @Column(nullable = false)
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @Column(name="capacity")
    @Min(0)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    TrainingStatus trainingStatus;

    @ElementCollection
    @CollectionTable(
            name = "training_enrollments",
            joinColumns = @JoinColumn(name = "training_id")
    )
    @Column(name = "trainer_Id")
    private List<Long> enrolledEmployeeIds = new ArrayList<>();
}
