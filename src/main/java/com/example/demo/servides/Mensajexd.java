package com.example.demo.servides;

import com.example.demo.model.Bicicleta;

public class Mensajexd {
    private Integer idMessage;
    private String messageText;
    private Bicicleta Bike;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Bicicleta getBike() {
        return Bike;
    }

    public void setBike(Bicicleta bike) {
        Bike = bike;
    }
}
