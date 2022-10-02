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
    private Integer idReservation;
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties("reservations")
    private usuario client;
    @ManyToOne
    @JoinColumn(name = "idBici")
        @JsonIgnoreProperties("reservations")
        private Bicicleta bike;
    private Date Startdate;
    private Date devolutionDate;
    public Integer getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
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
    public Date getStartdate() {
        return Startdate;
    }
    public void setStartdate(Date startdate) {
        Startdate = startdate;
    }
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    
}
