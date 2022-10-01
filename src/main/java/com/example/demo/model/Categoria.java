package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;




@Entity
@Table(name = "category")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @Column(name="bikes")
    @JsonIgnoreProperties("category")
    private List<Bicicleta> bicicletas;


    public Integer getid() {
        return id;
    }

    public void setId(Integer id) {
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Bicicleta> getbicicletas() {
        return bicicletas;
    }

    public void setbicicletas (List<Bicicleta> bicicletas) {
        this.bicicletas = bicicletas;
    }

    /*public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }*/
}

