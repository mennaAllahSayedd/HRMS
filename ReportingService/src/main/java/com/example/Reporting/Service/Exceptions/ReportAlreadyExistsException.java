package com.example.Reporting.Service.Exceptions;

public class ReportAlreadyExistsException extends RuntimeException {

    public ReportAlreadyExistsException(String message) {
            super(message);
        }
}
