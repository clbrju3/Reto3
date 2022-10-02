package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale.Category;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;
    private String palco;
    private String cliente;
    @ManyToOne
    @JoinColumn(name = "id")
        @JsonIgnoreProperties("reservations")
        private Bicicleta bicicleta;
    private Date fechainicio;
    private Date fechafin;
    public Integer getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
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
    public Bicicleta getBicicleta() {
        return bicicleta;
    }
    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
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


    

   


}
