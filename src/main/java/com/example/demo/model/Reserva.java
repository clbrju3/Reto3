package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="Reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", unique=true ,nullable = false)
    private int id;
    @Column(name="Bicicleta_id")
    private Integer Bici;
    @Column(name="Cliente_id")
    private Integer Id_cliente;
    @Column(name="Date")
    private Date Fecha;
    @Column(name="Fecah_entrega")
    private Date entrega;
}
