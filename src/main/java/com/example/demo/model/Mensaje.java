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
    @JoinColumn(name = "idBici")
    @JsonIgnoreProperties("messages")
    private Bicicleta biker;
    
    @Column(name="description")
    private String Des;

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public Bicicleta getBike() {
        return biker;
    }

    public void setBike(Bicicleta biker) {
        this.biker = biker;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }
    
}
