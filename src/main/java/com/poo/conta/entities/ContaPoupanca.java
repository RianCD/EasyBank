package com.poo.conta.entities;

import com.poo.cliente.entity.Cliente;
import com.poo.conta.enums.TipoConta;
import com.poo.transacao.enums.TipoTransacao;

import java.time.LocalDateTime;

public class ContaPoupanca extends Conta {
    
    public ContaPoupanca (Cliente client, Integer accountId, Float balance, TipoConta tipoConta){
        super(client, accountId, balance, tipoConta);
    }

    @Override
    public void withdraw(Float withdraw){
        float balance = getBalance() - withdraw;
        if(balance < 0){
            System.out.println("You don't have any value to withdraw");
        }else {
            setBalance(balance);
            transactionRegister(TipoTransacao.SAQUE, withdraw, LocalDateTime.now());
        }
    }
}