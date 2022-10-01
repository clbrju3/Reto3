package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Bike")
public class Bicicleta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", unique=true ,nullable = false)
    private int id;
    @Column(name="name", unique = true,nullable = false)
    private String nombre;
    @Column(name="brand", nullable = false)
    private String marca;
    @Column(name="description")
    private String descrip;
    @ManyToOne
    @JoinColumn(name="category")
    @JsonIgnoreProperties("bikes")
    private Categoria category;
    @Column(name="messages")
    String messages;
    @ManyToOne
    @JoinColumn(name="reservations")
    @JsonIgnoreProperties("bikes")
    private Reserva reservations;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getDescrip() {
        return descrip;
    }
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    public Categoria getCategory() {
        return category;
    }
    public void setCategory(Categoria category) {
        this.category = category;
    }
    public String getMessages() {
        return messages;
    }
    public void setMessages(String messages) {
        this.messages = messages;
    }
    public Reserva getReservations() {
        return reservations;
    }
    public void setReservations(Reserva reservations) {
        this.reservations = reservations;
    }
    
  
  
}
