package com.poo.cliente.entity;

import com.poo.conta.entities.Conta;
import com.poo.endereco.entity.Endereco;
import com.poo.infrastructure.exception.NotFoundAccountException;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final List<Conta> contas = new ArrayList<>();
    private String name;
    private String cpf;
    private String phone;
    private Endereco address;
    private int clienteId;

    public Cliente(String name, String cpf, String phone, Endereco address, int clienteId) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.clienteId = clienteId;
    }

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

    private List<Conta> getContas (){
        return contas;
    }

    public Cliente(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return "Dados do cliente:" +
                "name='" + name + '\'' +
                ", cpf=" + cpf +
                ", phone=" + phone +
                ", address=" + address;
    }
}
