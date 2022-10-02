package com.example.demo.servides;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.Mensarepo;
import com.example.demo.model.Mensaje;
@Repository
public class Mensajeservi {

    @Autowired
    private Mensarepo reservasCrudRepository;
    public List<Mensaje> getAll(){
        return (List<Mensaje>) reservasCrudRepository.findAll();
    }
    public Optional<Mensaje> getReservas(int id){
        return reservasCrudRepository.findById(id);
    }
    public Mensaje save(Mensaje p){
        return reservasCrudRepository.save(p);
    }
    public void delete(Mensaje p){
        reservasCrudRepository.delete(p);
    }

}
