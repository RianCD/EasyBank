package com.poo.infrastructure.exception;

public class InvalidTransactionValueException extends BankingException{
    public InvalidTransactionValueException(String message){
        super(message);
    }
}