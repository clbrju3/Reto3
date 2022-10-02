package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name = "bike")
    public class Bicicleta implements Serializable {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer idBici;
        private String name;
        private String year;
        private String description;
        private String brand;
        @ManyToOne
        @JoinColumn(name = "idCategory")
        @JsonIgnoreProperties("bikes")
        private Categoria category;
        @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "bike")
        @JsonIgnoreProperties("bike")
        private ArrayList<Reserva> reservations;
        @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "bike")
        @JsonIgnoreProperties("biker")
        private List<Mensaje> messages;
        public Integer getIdBici() {
            return idBici;
        }
        public void setIdBici(Integer idBici) {
            this.idBici = idBici;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getYear() {
            return year;
        }
        public void setYear(String year) {
            this.year = year;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getBrand() {
            return brand;
        }
        public void setBrand(String brand) {
            this.brand = brand;
        }
        public Categoria getCategory() {
            return category;
        }
        public void setCategory(Categoria category) {
            this.category = category;
        }
        public ArrayList<Reserva> getReservations() {
            return reservations;
        }
        public void setReservations(ArrayList<Reserva> reservations) {
            this.reservations = reservations;
        }
        public List<Mensaje> getMessages() {
            return messages;
        }
        public void setMessages(List<Mensaje> messages) {
            this.messages = messages;
        }
        
        
        
        

        
}
