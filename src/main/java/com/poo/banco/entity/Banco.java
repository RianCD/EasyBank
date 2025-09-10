package com.poo.banco.entity;

// import com.poo.cliente.entity.Cliente;
import com.poo.conta.entities.Conta;

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
        contas.add(conta);
    }

    public void searchConta(Integer accountId){
        for (Conta conta : contas){
            if(conta.getAccountId().equals(accountId))
                System.out.println(conta);
        }
    }

    public void listAccount(){
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    public List<Conta> getAccounts(){
        return contas;
    }

    public void deleteAccount(Integer accountId){
        boolean removed = contas.removeIf(conta -> conta.getAccountId().equals(accountId));
        if(removed){
            System.out.println("Account deleted");
        }else {
            System.out.println("There is no one account with Id " + accountId);
        }
    }
}