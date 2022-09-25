package com.example.demo.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Client")
public class usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", unique=true ,nullable = false)
 private int id;
 @Column(name="name", nullable = false)
 private String nombre;
 @Column(name="email", nullable = false)
 private String email;
 @Column(name="age")
 private Integer numero;
 @Column(name="password")
 private String contraseña;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
