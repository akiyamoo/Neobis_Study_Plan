package com.neobis.api.Exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException{
    private final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public NotFoundException(String param){
        super(param);
    }

    public NotFoundException(){
        //super("Don't have id");
    }

    public HttpStatus getSTATUS(){
        return STATUS;
    }

}
