package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="Message")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMessage", unique=true ,nullable = false)
    private int idMessage;
    private String messageText;
    @ManyToOne
    @JoinColumn(name = "idBike")
    @JsonIgnoreProperties({"messages","reservations"})
    private Bicicleta bike;
    @ManyToOne
    @JoinColumn(name="IdClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private usuario client;
    public int getIdMessage() {
        return idMessage;
    }
    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public Bicicleta getBike() {
        return bike;
    }
    public void setBike(Bicicleta bike) {
        this.bike = bike;
    }
    public usuario getClient() {
        return client;
    }
    public void setClient(usuario client) {
        this.client = client;
    }
    
    
}
