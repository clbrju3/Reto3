package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="Message")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMessage", unique=true ,nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("messages")
    private Bicicleta bike;
    
    @Column(name="description")
    private String Des;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bicicleta getBike() {
        return bike;
    }

    public void setBike(Bicicleta bike) {
        this.bike = bike;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }
    
}
