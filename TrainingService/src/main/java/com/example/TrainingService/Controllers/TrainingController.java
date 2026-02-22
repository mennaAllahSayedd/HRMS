package com.example.TrainingService.Controllers;


import com.example.TrainingService.Dto.EmployeeDto;
import com.example.TrainingService.Dto.TrainingDto;
import com.example.TrainingService.Entities.Training;
import com.example.TrainingService.Services.TrainingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping("/all")
    public ResponseEntity<List<TrainingDto>> getAvailableTrainings() {

        try {
            List<TrainingDto> trainingDtos = trainingService.getAvailableTrainings();
            return ResponseEntity.ok(trainingDtos);
        }catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Create a new training")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Training created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TrainingDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<TrainingDto> createTraining(@Valid @RequestBody TrainingDto trainingDto) {
     try {
         log.info("REST request to create training with num: {}", trainingDto.getTrainingNum());

         TrainingDto response = trainingService.createTraining(trainingDto);

         log.info("Training created successfully with num: {}", response.getTrainingNum());

         return new ResponseEntity<>(response, HttpStatus.CREATED);
     }catch (RuntimeException e) {
         throw new RuntimeException(e);
     }}
    @Operation(summary = "Update an existing training")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Training updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TrainingDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Training not found",
                    content = @Content)
    })
    @PutMapping
    public ResponseEntity<TrainingDto> updateTraining(
            @Valid @RequestBody TrainingDto trainingDto) {
     try{
        log.info("REST request to update training with num: {}", trainingDto.getTrainingNum());

        TrainingDto response = trainingService.updateTraining(trainingDto);

        log.info("Training updated successfully with num: {}", response.getTrainingNum());

        return ok(response);
     }catch (RuntimeException e) {
         throw new RuntimeException(e);
     }
    }

    // DELETE
    @DeleteMapping("/{trainingNum}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long trainingNum) {

        try{
        log.warn("REST request to delete training with num: {}", trainingNum);

        trainingService.deleteTraining(trainingNum);

        log.warn("Training deleted successfully with num: {}", trainingNum);

        return ResponseEntity.noContent().build();
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


    @PostMapping("/enroll")
    public EmployeeDto enroll(@RequestParam Long userId) {
        try {
            return trainingService.enrollUserToTraining(userId);
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Get a training by its number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Training found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TrainingDto.class))),
            @ApiResponse(responseCode = "404", description = "Training not found",
                    content = @Content)
    })
    @GetMapping("/{trainingNum}")
    public ResponseEntity<TrainingDto> getTrainingByNum(@PathVariable Long trainingNum) {

        try{
        log.info("REST request to get training with num: {}", trainingNum);

        return ok(trainingService.getTrainingByNum(trainingNum));
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> isEmployeeEnrolled(@RequestParam Long empId ,@RequestParam String trainingName){
        return null;
    }

    @GetMapping("/enroll")
   public ResponseEntity<TrainingDto> enrollEmployee(@RequestParam Long empId,@RequestParam String trainingName){
        return null;
    }
}
