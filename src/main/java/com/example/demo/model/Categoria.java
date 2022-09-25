package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="category")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", unique=true ,nullable = false)
    private int id;
    @Column(name="name")
    private Integer nombre;
    @Column(name="description")
    private String Des;
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Bicicleta> bikes;

}
