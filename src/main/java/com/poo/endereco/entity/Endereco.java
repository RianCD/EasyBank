package com.poo.endereco.entity;

public class Endereco {
    private String city;
    private Integer cep;
    private String street;
    private String state;
    private Integer house;

    public Endereco(String city, Integer cep, String street, String state, Integer house) {
        this.city = city;
        this.cep = cep;
        this.street = street;
        this.state = state;
        this.house = house;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "city='" + city + '\'' +
                ", cep=" + cep +
                ", street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", house=" + house +
                '}';
    }
}
