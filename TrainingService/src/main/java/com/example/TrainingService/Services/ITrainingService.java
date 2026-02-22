package com.example.TrainingService.Services;


import com.example.TrainingService.Dto.TrainingDto;
import com.example.TrainingService.Entities.Training;

import java.util.List;

public interface ITrainingService {

    TrainingDto assignTrainer(Long trainingId, Long trainerId);

    TrainingDto createTraining(TrainingDto trainingDto);

    TrainingDto updateTraining(TrainingDto trainingDto);

    void deleteTraining(Long trainingNum);

    TrainingDto getTrainingByNum(Long trainingNum);

    public List<TrainingDto> getAvailableTrainings();
}
