package com.example.TrainingService.Exceptions;

public class NoSuchTrainingFoundException extends RuntimeException {

    public NoSuchTrainingFoundException(String message) {
        super(message);
    }
}
