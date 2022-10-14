package com.example.demo.servides;
import com.example.demo.model.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.repository.Reservarepo;
import com.example.demo.repository.usureposit;

import java.lang.reflect.Array;
import java.util.*;

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
        List<Reserva> fui=getAll();
        ArrayList<Reserva> wer=new ArrayList<>();
        for(int i=0;i<fui.size();i++){
            if(fui.get(i).getStartDate().compareTo(x)>0 && fui.get(i).getDevolutionDate().compareTo(y)<0){
                wer.add(fui.get(i));
            }
        }
        return wer;
    }
    public Map<Integer,Integer> countFrequencies(ArrayList<Integer> list) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (Integer i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        /*for (Map.Entry<String, Integer> val : hm.entrySet()) {
            System.out.println("Element " + val.getKey() + " "
                    + "occurs"
                    + ": " + val.getValue() + " times");
        }*/
        return hm;
    }
    public ArrayList<Conteo> Conteo(){
        List<Reserva> p= (List<Reserva>) reservasCrudRepository.findAll();
        Conteo de=new Conteo();
        ArrayList<Integer> re=new ArrayList<>();
        ArrayList<Conteo> fr=new ArrayList<>();
        for(int i=0;i<p.size();i++){
            re.add(p.get(i).getClient().getIdClient());
        }
        Map<Integer,Integer>z=countFrequencies(re);
        Integer[] seq= (Integer[]) z.keySet().toArray();
        for(int s=0;s<z.size();s++){
            de.setTotal(z.get(seq[s]));
            de.setClient(usureposit.findById(seq[s]).get());
            fr.add(de);
        }
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

