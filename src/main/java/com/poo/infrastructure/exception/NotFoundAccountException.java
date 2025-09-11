package com.poo.infrastructure.exception;

public class NotFoundAccountException extends BankingException{
    public NotFoundAccountException(String message){
        super(message);
    }
}