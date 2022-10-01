package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;
    private String palco;
    @OneToMany
    @JoinColumn(name="client")
    @JsonIgnoreProperties("clients")
    private String cliente;
    private Date fechainicio;
    private Date fechafin;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("clients")
    private Categoria category;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer id) {
        this.idReserva = id;
    }

    public String getPalco() {
        return palco;
    }

    public void setPalco(String palco) {
        this.palco = palco;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }
}
