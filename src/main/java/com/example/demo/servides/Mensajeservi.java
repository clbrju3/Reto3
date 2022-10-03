package com.example.demo.servides;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.usuario;
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
    public Mensaje actualizar(Mensaje p){
        if(p.getIdMessage()!=null){
            Optional<Mensaje> q = getReservas(p.getIdMessage());
            if(q.isPresent()) {
                if (p.getMessageText() != null) {
                    q.get().setMessageText(p.getMessageText());
                }


                reservasCrudRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public Mensaje save(Mensaje p){
        return reservasCrudRepository.save(p);
    }
    public void delete(Mensaje p){
        reservasCrudRepository.delete(p);
    }

}
