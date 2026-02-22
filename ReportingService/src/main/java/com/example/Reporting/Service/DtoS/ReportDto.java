package com.example.Reporting.Service.DtoS;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReportDto {

    @NotNull(message = "uuid can't be null")
    private String uuid;

    @NotBlank(message = "Report name must not be blank")
    @Size(max = 100, message = "Report name must not exceed 100 characters")
    private String reportName;

    @Size(max = 1000, message = "Report description must not exceed 1000 characters")
    private String reportDescription;

    private String generatedBy;

    private LocalDateTime generatedAt;

    @NotBlank(message = "Report data must not be blank")
    private String reportData;
}
