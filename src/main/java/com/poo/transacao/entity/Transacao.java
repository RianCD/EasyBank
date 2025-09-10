package com.poo.transacao.entity;

import com.poo.transacao.enums.TipoTransacao;

import java.time.LocalDateTime;

public class Transacao {
    private TipoTransacao transactionType;
    private Float value;
    private LocalDateTime dateAndHour;

    public Transacao(TipoTransacao transactionType, Float value, LocalDateTime dateAndHour) {
        this.transactionType = transactionType;
        this.value = value;
        this.dateAndHour = dateAndHour;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "transactionType=" + transactionType +
                ", value=" + value +
                ", dateAndHour=" + dateAndHour +
                '}';
    }

    public TipoTransacao getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TipoTransacao transactionType) {
        this.transactionType = transactionType;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public LocalDateTime getDateAndHour() {
        return dateAndHour;
    }

    public void setDateAndHour(LocalDateTime dateAndHour) {
        this.dateAndHour = dateAndHour;
    }
}