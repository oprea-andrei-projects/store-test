package com.example.storetest.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItemAlreadyExistsException extends RuntimeException{

    public ItemAlreadyExistsException(String msg){

        super(msg);
    }
}
