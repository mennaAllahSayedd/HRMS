package com.example.LeaveService.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchLeaveExistsException extends RuntimeException {

    String msg;
    public NoSuchLeaveExistsException(String _msg){
        super(_msg);
        msg =_msg;
    }
}
