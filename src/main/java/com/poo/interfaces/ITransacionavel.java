package com.poo.interfaces;

import com.poo.conta.entities.Conta;
import com.poo.infrastructure.exception.InvalidTransactionValueException;

public interface ITransacionavel {
    void deposit (Float deposit)  throws InvalidTransactionValueException;
    void transfer(Conta recipient, Float value) throws InvalidTransactionValueException;
    void withdraw(Float withdraw);
}