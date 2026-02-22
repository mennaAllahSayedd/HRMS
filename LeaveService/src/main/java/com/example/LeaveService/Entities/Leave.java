package com.example.LeaveService.Entities;

import com.example.LeaveService.Enums.LeaveStatus;
import com.example.LeaveService.Enums.LeaveType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="uuid",unique = true)
    private String uuid;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private LocalDate startDate;

    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    // VARCHAR(255)
    private LeaveStatus status;

    private String reason;

    private Long employeeId;

}
