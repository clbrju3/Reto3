package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.RequestBody;

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
    @ManyToOne
    @JoinColumn(name="Category_id")
    @JsonIgnoreProperties("bikes")
    private Categoria category;
    @Column(name="year")
    private Integer año;
    @Column(name="Description")
    private String descrip;

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

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
