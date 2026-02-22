package com.example.TrainingService.Services;

import com.example.TrainingService.Client.UserClient;
import com.example.TrainingService.Dto.EmployeeDto;
import com.example.TrainingService.Dto.TrainingDto;
import com.example.TrainingService.Entities.Training;
import com.example.TrainingService.Exceptions.NoSuchTrainingFoundException;
import com.example.TrainingService.Exceptions.TrainingAlreadyExistsException;
import com.example.TrainingService.Mapper.TrainingMapper;
import com.example.TrainingService.Repositories.TrainingRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j

public class TrainingService implements ITrainingService {

    private TrainingRepo trainingRepo;
    private final UserClient userClient;


    public EmployeeDto enrollUserToTraining(Long id){
      EmployeeDto  employee= userClient.getEmployeeById(id);
      return employee;
    }

    @Override
    public List<TrainingDto> getAvailableTrainings() {

        return trainingRepo.findAll()
                .stream()
                .map(training -> TrainingMapper.mapToTrainingDto(new TrainingDto(),training))
                .collect(Collectors.toList());


    }
    @Override
    public TrainingDto assignTrainer(Long trainingId, Long trainerId) {

//        Training training = trainingRepo.findById(trainingId)
//                .orElseThrow(() -> new RuntimeException("Training not found"));
//
//        training.setTrainerId(trainerId);
//
//        return TrainingMapper.mapToTrainingDto(trainingRepo.save(training));
        return null;
    }

    @Override
    public TrainingDto createTraining(TrainingDto trainingDto) {

        Training training = TrainingMapper.mapToTraining(new Training(),trainingDto);
        Optional<Training> currtraining =  trainingRepo.findByTrainingNum(training.getTrainingNum());

        if(currtraining.isPresent()){
            log.warn("Training Already Exists");
            throw new TrainingAlreadyExistsException("Training Already Exists");
        }

        Training newTraining = trainingRepo.save(training);
        log.info("Training Create Successfully.");
        return TrainingMapper.mapToTrainingDto(new TrainingDto(),newTraining);


    }

    @Override
    public TrainingDto updateTraining( TrainingDto trainingDto) {

        Training training = trainingRepo.findByTrainingNum(trainingDto.getTrainingNum())
                .orElseThrow(() -> new RuntimeException("Trianing Not Found"));

        Training updatedTraining =
                TrainingMapper.mapToTraining(training, trainingDto);

        Training savedTraining = trainingRepo.save(updatedTraining);
        log.info("Training Updated Successfully.");

        return TrainingMapper.mapToTrainingDto(
                new TrainingDto(), savedTraining);

    }

    @Override
    public void deleteTraining(Long trainingNum) {

        Training training = trainingRepo.findByTrainingNum(trainingNum).orElseThrow(
                () -> new NoSuchTrainingFoundException("This Training Not Found")
        );
        trainingRepo.deleteById(training.getId());
        log.info("Training Deleted Successfully.");

    }

    @Override
    public TrainingDto getTrainingByNum(Long trainingNum) {

        Training training = trainingRepo.findByTrainingNum(trainingNum).orElseThrow(
                ()-> new NoSuchTrainingFoundException("Training Not Exists")
        );

        TrainingDto mappedTraining =TrainingMapper.mapToTrainingDto(new TrainingDto(),training);
        return mappedTraining;
    }



}
