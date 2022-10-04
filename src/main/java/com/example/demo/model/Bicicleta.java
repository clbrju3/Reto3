package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

    @Entity
    @Table(name = "bike")
    public class Bicicleta implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="idx")
        private Integer id;
        private String name;
        private String brand;
        private Integer year;
        private String description;
        
        @ManyToOne
        @JoinColumn(name = "id")
        @JsonIgnoreProperties("bikes")
        private Categoria category;
        @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "bike")
        @JsonIgnoreProperties("bike")
        private List<Mensaje> messages;
        @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "bike")
        @JsonIgnoreProperties("bike")
        private List<Reserva> reservations;
        
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Integer getYear() {
            return year;
        }
        public void setYear(Integer year) {
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
        public List<Reserva> getReservations() {
            return reservations;
        }
        public void setReservations(List<Reserva> reservations) {
            this.reservations = reservations;
        }
        public List<Mensaje> getMessages() {
            return messages;
        }
        public void setMessages(List<Mensaje> messages) {
            this.messages = messages;
        }
        
        
        
        

        
}
