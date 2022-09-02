package com.example.storetest.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoCategoryFoundException extends RuntimeException{

    public NoCategoryFoundException(String msg){

        super(msg);
    }
}
