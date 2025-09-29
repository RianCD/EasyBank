package com.poo.banco.entity;

// import com.poo.cliente.entity.Cliente;
import com.poo.cliente.entity.Cliente;
import com.poo.conta.entities.Conta;
import com.poo.infrastructure.exception.NotFoundAccountException;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private final List<Cliente> clientes = new ArrayList<>();


    public void addCliente(Cliente cliente){
        if(cliente == null){
            throw new IllegalArgumentException("Account can't be null.");
        }
        clientes.add(cliente);
    }

    public Cliente searchCliente(Integer clienteId){
        return clientes.stream()
                .filter(conta -> conta.getClienteId().equals(clienteId))
                .findFirst()
                .orElseThrow(() -> new NotFoundAccountException("There is no one account with Id " + clienteId));
    }

    public void listCliente(){
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void deleteAccount(Integer clienteId){
        boolean removed = clientes.removeIf(conta -> conta.getClienteId().equals(clienteId));
        if(removed){
            System.out.println("Account deleted");
        }else {
            throw new NotFoundAccountException("There is no one account with Id " + clienteId);
        }
    }

}