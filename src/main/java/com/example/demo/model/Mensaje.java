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
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("messages")
    private Bicicleta bike;
    
    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name="IdClient")
    @JsonIgnoreProperties("client")
    private usuario client;
    public int getIdMessage() {
        return idMessage;
    }
    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }
    public Bicicleta getBike() {
        return bike;
    }
    public void setBike(Bicicleta bike) {
        this.bike = bike;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public usuario getClient() {
        return client;
    }
    public void setClient(usuario client) {
        this.client = client;
    }
    
    
}
