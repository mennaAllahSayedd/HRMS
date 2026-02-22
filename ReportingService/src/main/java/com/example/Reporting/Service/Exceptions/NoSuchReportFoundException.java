package com.example.Reporting.Service.Exceptions;

public class NoSuchReportFoundException extends RuntimeException {

    public NoSuchReportFoundException(String message) {
        super(message);
    }
}
