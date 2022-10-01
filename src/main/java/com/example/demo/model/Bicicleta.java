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
        private String target;
        private String description;
        @ManyToOne
        @JoinColumn(name = "idcategory")
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
        public String getTarget() {
            return target;
        }
        public void setTarget(String target) {
            this.target = target;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public Categoria getCategory() {
            return category;
        }
        public void setCategory(Categoria category) {
            this.category = category;
        }
  
}}
