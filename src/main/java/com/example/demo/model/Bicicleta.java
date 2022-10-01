package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

    @Entity
    @Table(name = "bike")
    public class Bicicleta implements Serializable {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;
        private String year;
        private String description;
        private String brand;
        @ManyToOne
        @JoinColumn(name = "idCategory")
        @JsonIgnoreProperties("bikes")
        private Categoria category;
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

}
