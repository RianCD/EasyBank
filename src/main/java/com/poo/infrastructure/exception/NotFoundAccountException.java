package com.poo.infrastructure.exception;

public class NotFoundAccountException extends RuntimeException{
    public NotFoundAccountException(String message){
        super(message);
    }
}
