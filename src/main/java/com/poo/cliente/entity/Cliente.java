package com.poo.cliente.entity;

import com.poo.endereco.entity.Endereco;

public class Cliente {
    private String name;
    private String cpf;
    private String phone;
    private Endereco address;

    public Cliente(String name, String cpf, String phone, Endereco address) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
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

    @Override
    public String toString() {
        return "Dados do cliente:" +
                "name='" + name + '\'' +
                ", cpf=" + cpf +
                ", phone=" + phone +
                ", address=" + address;
    }
}
