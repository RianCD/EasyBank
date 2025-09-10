package com.poo.conta.entities;

import com.poo.cliente.entity.Cliente;
import com.poo.conta.enums.TipoConta;
import com.poo.transacao.enums.TipoTransacao;

import java.time.LocalDateTime;

public class ContaCorrente extends Conta {

    Float withdrawCredit = 200.0f;

    public ContaCorrente (Cliente client, Integer accountId, Float balance, TipoConta tipoConta){
        super(client, accountId, balance, tipoConta);
    }

    @Override
    public void withdraw(Float withdraw){
        float balance = getBalance() - withdraw;
        
        if (balance >= (withdrawCredit * (-1))){
            setBalance(balance);
            transactionRegister(TipoTransacao.SAQUE, withdraw, LocalDateTime.now());
        }else{
            System.out.println("You exceeded your withdrawn credit that is " + withdrawCredit);
        }
    }
}