package com.example.TrainingService.Mapper;

import com.example.TrainingService.Dto.TrainingDto;
import com.example.TrainingService.Entities.Training;

public class TrainingMapper {
    public static TrainingDto mapToTrainingDto(TrainingDto trainingDto, Training training){

        trainingDto.setTrainingNum(training.getTrainingNum());
        trainingDto.setTitle(training.getTitle());
        trainingDto.setStartDate(training.getStartDate());
        trainingDto.setEndDate(training.getEndDate());
        trainingDto.setCapacity(training.getCapacity());
        trainingDto.setTrainingStatus(training.getTrainingStatus());
//        trainingDto.setTrainerId(training.getTrainerId());
        return trainingDto;
    }

    public static Training mapToTraining( Training training,TrainingDto trainingDto){

        training.setTrainingNum(trainingDto.getTrainingNum());
        training.setTitle(trainingDto.getTitle());
        training.setStartDate(trainingDto.getStartDate());
        training.setEndDate(trainingDto.getEndDate());
        training.setCapacity(trainingDto.getCapacity());
        training.setTrainingStatus(trainingDto.getTrainingStatus());
//        training.setTrainerId(trainingDto.getTrainerId());
        return training;
    }
}
