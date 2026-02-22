package com.example.UserService.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmployeeAlreadyExistsException extends RuntimeException{
    private String msg;

    public EmployeeAlreadyExistsException(String _msg){
        super(_msg);
        msg= _msg;
    }


}
