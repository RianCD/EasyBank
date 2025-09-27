package com.poo.infrastructure.exception;

public class NotFoundClientException extends BankingException {
    public NotFoundClientException(String message) {
        super(message);
    }
}
