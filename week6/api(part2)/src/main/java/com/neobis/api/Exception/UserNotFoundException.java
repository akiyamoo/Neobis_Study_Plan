package com.neobis.api.Exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException{

    final HttpStatus STATUS = HttpStatus.NOT_FOUND;


    public UserNotFoundException(String param){
        super(param);
    }

    public UserNotFoundException(){
        super("Don't have id");
    }

    public HttpStatus getSTATUS() {
        return STATUS;
    }
}
