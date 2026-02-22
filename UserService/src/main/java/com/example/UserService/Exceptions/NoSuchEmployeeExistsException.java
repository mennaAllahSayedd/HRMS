package com.example.UserService.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchEmployeeExistsException extends RuntimeException {

    String msg;

    public NoSuchEmployeeExistsException(String _msg){
        super(_msg);
        msg =_msg;
    }
}
