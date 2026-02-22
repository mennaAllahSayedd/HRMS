package com.example.TrainingService.Exceptions;

public class TrainingAlreadyExistsException extends RuntimeException {

    public TrainingAlreadyExistsException(String message) {
            super(message);
        }
}
