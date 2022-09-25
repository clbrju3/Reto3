package com.example.demo.model;

import javax.persistence.*;
@Entity
@Table(name="Mensssage")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", unique=true ,nullable = false)
    private int id;

    @Column(name="Bicicleta_id")
    private Integer Bici;
    @Column(name="description")
    private String Des;
}
