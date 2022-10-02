package com.example.demo.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="client")
public class usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String name;
    private Integer age;
    private String password;
    private String email;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
        @JsonIgnoreProperties("client")
        private List<Mensaje> messages;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
        @JsonIgnoreProperties("client")
        private List<Reserva> reservations;
}
