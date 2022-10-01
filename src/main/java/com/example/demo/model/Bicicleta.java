package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Bike")
public class Bicicleta implements Serializable {
    @Entity
    @Table(name = "bike")
    public class Library implements Serializable {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;
        private String target;
        private String description;
        @ManyToOne
        @JoinColumn(name = "categoryId")
        @JsonIgnoreProperties("libs")
        private Categoria category;
  
}
