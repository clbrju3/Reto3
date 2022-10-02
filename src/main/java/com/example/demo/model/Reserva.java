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
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties("reservations")
    private usuario client;
    @ManyToOne
    @JoinColumn(name = "idBici")
        @JsonIgnoreProperties("reservations")
        private Bicicleta bike;
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
    public usuario getClient() {
        return client;
    }
    public void setClient(usuario client) {
        this.client = client;
    }
    public Bicicleta getBike() {
        return bike;
    }
    public void setBike(Bicicleta bike) {
        this.bike = bike;
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
