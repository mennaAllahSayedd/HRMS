package com.example.TrainingService.Repositories;

import com.example.TrainingService.Entities.TrainingEmployee;
import com.example.TrainingService.Entities.TrainingEmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingEmployeeRepository extends JpaRepository<TrainingEmployee, TrainingEmployeeId> {

    boolean existsByIdTrainingIdAndIdEmployeeId(Long trainingId, Long employeeId);
}
