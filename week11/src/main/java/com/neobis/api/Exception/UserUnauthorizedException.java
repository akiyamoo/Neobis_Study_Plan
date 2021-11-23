package com.neobis.api.Exception;

import org.springframework.http.HttpStatus;

public class UserUnauthorizedException extends RuntimeException {

    private static final HttpStatus STATUS = HttpStatus.UNAUTHORIZED;

    public UserUnauthorizedException(String param){
        super(param);
    }

    public UserUnauthorizedException(){}

    public HttpStatus getSTATUS(){
        return STATUS;
    }

}
