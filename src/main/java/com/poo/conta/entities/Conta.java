package com.poo.conta.entities;

import com.poo.cliente.entity.Cliente;
import com.poo.conta.enums.TipoConta;
import com.poo.infrastructure.exception.InvalidTransactionValueException;
import com.poo.transacao.entity.Transacao;
import com.poo.transacao.enums.TipoTransacao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private final Cliente client;
    private final List<Transacao> transactionHistory = new ArrayList<>();
    private final Integer accountId;
    private Float balance;
    private TipoConta tipoConta;

    public Conta(Cliente client, Integer accountId, Float balance, TipoConta tipoConta){
        this.client = client;
        this.accountId = accountId;
        this.balance = balance;
        this.tipoConta = tipoConta;
    }

    public void transactionRegister(TipoTransacao transactionType, Float value, LocalDateTime dateAndHour){
        Transacao transacao = new Transacao(transactionType,value, LocalDateTime.now());
        transactionHistory.add(transacao);
    }

    public void transfer(Conta recipient, Float value) throws InvalidTransactionValueException{
        withdraw(value);
        Float recipientBalance = recipient.getBalance() + value;
        recipient.setBalance(recipientBalance);
        transactionRegister(TipoTransacao.TRANSACAO_ENVIADA, value, LocalDateTime.now());
        recipient.transactionRegister(TipoTransacao.TRANSACAO_RECEBIDA, value, LocalDateTime.now());
        System.out.println("Transfer succeed!");
    }

    public void deposit(Float deposit) throws InvalidTransactionValueException {
        if(deposit <= 0){
            throw new InvalidTransactionValueException("Invalid deposit value: " + deposit);
        }
        Float balance = getBalance() + deposit;
        setBalance(balance);
        transactionRegister(TipoTransacao.DEPOSITO,deposit, LocalDateTime.now());
    }

    public abstract void withdraw(Float withdraw);

    public Float getBalance(){
        return balance;
    }

    protected void setBalance(Float balance){ //método deve ser protegido para que apenas as classes que herdam possam utilizar
        this.balance = balance;
    }

    public Integer getAccountId(){
        return accountId;
    }

    public TipoConta getTipoConta(){
        return tipoConta;
    }

    public void listTransactionHistory(){
        for (Transacao transaction : transactionHistory){
            System.out.println(transaction);
        }
    }

    @Override
    public String toString(){
        return "Owner: " + client.getName() + "\n" +
                "Account Id: " + getAccountId() + "\n" +
                "Balance: " + getBalance() + "\n" +
                "Account type: " + getTipoConta();
    }
}