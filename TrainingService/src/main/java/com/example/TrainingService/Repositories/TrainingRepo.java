package com.example.TrainingService.Repositories;

import com.example.TrainingService.Entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRepo extends JpaRepository<Training,Long> {

    Optional<Training> findByTrainingNum(Long trainingNum);

}
