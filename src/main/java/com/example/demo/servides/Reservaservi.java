package com.example.demo.servides;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reserva;
import com.example.demo.repository.Reservarepo;

import java.util.List;
import java.util.Optional;

@Repository
public class Reservaservi {

    @Autowired
    private Reservarepo reservasCrudRepository;
    public List<Reserva> getAll(){
        return (List<Reserva>) reservasCrudRepository.findAll();
    }
    public Optional<Reserva> getReservas(int id){
        return reservasCrudRepository.findById(id);
    }
    public Reserva save(Reserva p){
        return reservasCrudRepository.save(p);
    }
    public void delete(Reserva p){
        reservasCrudRepository.delete(p);
    }

}
