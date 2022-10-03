package com.example.demo.servides;



import com.example.demo.model.Bicicleta;
import com.example.demo.model.Mensaje;
import com.example.demo.repository.Bicirepo;
import com.example.demo.repository.Mensarepo;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reserva;
import com.example.demo.repository.Reservarepo;
import com.example.demo.servides.jsonxd.*;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class Reservaservi {

    @Autowired
    private Reservarepo reservasCrudRepository;

    public List<Reserva> getAll(){
        List<Reserva> fui=(List<Reserva>) reservasCrudRepository.findAll();
        jsonxd jason=new jsonxd();
        for(Reserva x:fui){
            for(int i=0;i<x.getBike().getMessages().size();i++){
                Integer id=(x.getBike().getMessages().get(i).getIdMessage());
                Bicicleta bici=(x.getBike().getMessages().get(i).getBike());
                String texto=(x.getBike().getMessages().get(i).getMessageText());
                Mensajexd Mensaje=new Mensajexd();
                Mensaje.setIdMessage(id);
                Mensaje.setMessageText(texto);
                Mensaje.setBike(bici);
                System.out.println(jason.jsonp(Mensaje));
            }
        }

        return fui;
    }


    public Optional<Reserva> getReservas(int id){
        return reservasCrudRepository.findById(id);
    }
    public Reserva save(Reserva p){
        return reservasCrudRepository.save(p);
    }
    public Reserva actualizar(Reserva p){
        if(p.getIdReservation()!=null){
            Optional<Reserva> q = getReservas(p.getIdReservation());
            if(q.isPresent()){
                if(p.getScore()!=null){
                    q.get().setScore(p.getScore());
                }
                if(p.getStatus()!=null){
                    q.get().setStatus(p.getStatus());
                }
                if(p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                if(p.getStartDate()!=null){
                    q.get().setStartDate(p.getStartDate());
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
    public void delete(Reserva p){
        reservasCrudRepository.delete(p);
    }

}
