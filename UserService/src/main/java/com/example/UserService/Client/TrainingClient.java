package com.example.UserService.Client;

import com.example.UserService.Dto.TrainingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "training-service", url = "http://localhost:9090")
public interface TrainingClient {

    @GetMapping("/api/trainings/all")
    List<TrainingDto> getAvailableTrainings();

    @GetMapping("/api/trainings/check")
    Boolean isEmployeeEnrolled(@RequestParam Long empId ,@RequestParam String trainingName);

    @GetMapping("/api/trainings/enroll")
    TrainingDto enrollEmployee(@RequestParam Long empId,@RequestParam String trainingName);
}
