package com.example.TrainingService.Dto;

import com.example.TrainingService.Enum.TrainingStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TrainingDto {

    @NotNull(message="Training Can't Be null")
    Long trainingNum;

    private String title;

    private String description;

    @NotNull(message = "Start date must not be null")
    @FutureOrPresent(message = "Start date must be today or in the future")
    private LocalDate startDate;

    @NotNull(message = "End date must not be null")
    @Future(message = "End date must be in the future")
    private LocalDate endDate;

    @NotNull(message = "training status must not be null")
    TrainingStatus trainingStatus;

    @NotNull(message = "Capacity must not be null")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    private Long trainerId;
}
