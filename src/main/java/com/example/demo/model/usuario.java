package com.example.demo.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="client")
public class usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    
    private Integer age;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
        @JsonIgnoreProperties("client")
        private List<Mensaje> messages;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
        @JsonIgnoreProperties("client")
        private List<Reserva> reservations;
    public Integer getIdClient() {
        return idClient;
    }
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Mensaje> getMessages() {
        return messages;
    }
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }
    public List<Reserva> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reserva> reservations) {
        this.reservations = reservations;
    }
        
}
