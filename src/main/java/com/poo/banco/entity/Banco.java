package com.poo.banco.entity;

// import com.poo.cliente.entity.Cliente;
import com.poo.conta.entities.Conta;
import com.poo.infrastructure.exception.NotFoundAccountException;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private final List<Conta> contas = new ArrayList<>();
    // private List<Cliente> clientes = new ArrayList<>();
    /*In Java, the final keyword,
     when applied to a field (instance variable), signifies that the field's value, once initialized,
     cannot be reassigned.
    */

    public void addConta(Conta conta){
        if(conta == null){
            throw new IllegalArgumentException("Account can't be null.");
        }
        contas.add(conta);
    }

    public Conta searchConta(Integer accountId){
        return contas.stream()
                .filter(conta -> conta.getAccountId().equals(accountId))
                .findFirst()
                .orElseThrow(() -> new NotFoundAccountException("There is no one account with Id " + accountId));
    }

    public void listAccount(){
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    public void deleteAccount(Integer accountId){
        boolean removed = contas.removeIf(conta -> conta.getAccountId().equals(accountId));
        if(removed){
            System.out.println("Account deleted");
        }else {
            throw new NotFoundAccountException("There is no one account with Id " + accountId);
        }
    }

    public void transfer (int ownerId, int recipientId, Float value){
        Conta owner = searchConta(ownerId);
        Conta recipient = searchConta(recipientId);

        owner.transfer(recipient, value);
    }
}