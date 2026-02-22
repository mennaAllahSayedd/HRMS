package com.example.authService.Exception;

public class UserNotFoundException extends RuntimeException{

    String msg;

    public UserNotFoundException(String _msg){
        super(_msg);
         msg =_msg;
    }
}
