package com.example.demo.servides;
import com.example.demo.model.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.repository.Reservarepo;
import com.example.demo.repository.usureposit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Reservaservi {

    @Autowired
    private Reservarepo reservasCrudRepository;
    private usureposit usureposit;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Reserva> getAll(){
        List<Reserva> fui=(List<Reserva>) reservasCrudRepository.findAll();
        ArrayList<Mensaje> ft=new ArrayList<>();
        ArrayList<Reserva> frty=new ArrayList<>();
        for(Reserva x:fui) {
            List<Mensaje> y = x.getBike().getMessages();
            for(Mensaje r:y){
                r.setClient(null);
                ft.add(r);
                x.getBike().setMessages(ft);
                }
            x.setBike(x.getBike());
            frty.add(x);
            }
        return frty;
    }


    public Optional<Reserva> getReservas(int id){return reservasCrudRepository.findById(id);}
    public Reserva save(Reserva p){
        if(p.getStatus()==null){
            p.setStatus("created");
        }
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
    public List<Reserva> EncontrarReservas(Date x, Date y){
        List<Reserva> fui=(List<Reserva>) reservasCrudRepository.findAll();
        List<Reserva> wer=null;
        for(int i=0;i<fui.size();i++){
            if(fui.get(i).getStartDate().compareTo(x)>0 && fui.get(i).getDevolutionDate().compareTo(y)<0){
                wer.add(fui.get(i));
            }
        }
        return wer;
    }
    public ArrayList<Conteo> Conteo(){
        List<Reserva> p=(List<Reserva>) reservasCrudRepository.findAll();
        Conteo de=new Conteo();
        ArrayList<Conteo> fr=new ArrayList<>();
        Integer y=0;
        for(int i=0;i<p.size();i++){
            Optional<usuario>z=usureposit.findById(i);
            for(int j=0;j<p.size();j++){
                if(p.get(j).getClient().getIdClient()==i){
                    y+=1;
                }
                if(y!=0){
                    de.setClient(z.get());
                    de.setTotal(y);
                    fr.add(de);}

            }}
        return fr;
    }
    public Completo Reporte(){
        List<Reserva> fui=(List<Reserva>) reservasCrudRepository.findAll();
        Completo x=new Completo();
        Integer y=0 ;
        Integer r=0;
        for(int i=0;i<fui.size();i++){
            if(fui.get(i).getStatus().equals("completed")){
                y+=1;
            }
            if(fui.get(i).getStatus().equals("cancelled")){
                r+=1;
        }
    }
        x.setCompleted(y);
        x.setCancelled(r);
        return x;
}

}
