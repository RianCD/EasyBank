package com.poo.infrastructure.exception;

public class InvalidTransactionValueException extends RuntimeException{
    public InvalidTransactionValueException(String message){
        super(message);
    }
}