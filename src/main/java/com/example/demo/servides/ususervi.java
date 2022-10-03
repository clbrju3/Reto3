package com.example.demo.servides;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.hibernate.boot.model.source.spi.SizeSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.usuario;
import com.example.demo.repository.usureposit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ususervi {
    @Autowired
    usureposit usureposit;

    public ArrayList<usuario> resultado(){
     jsontraer();
        return (ArrayList<usuario>) usureposit.findAll();
    }
    public usuario guardar(usuario usua){
        return usureposit.save(usua);
    }
    public Optional<usuario> ObtenerporId(Integer Id) {
        return usureposit.findById(Id);
    }
    public usuario actualizar(usuario p){
        if(p.getIdClient()!=null){
            Optional<usuario> q = ObtenerporId(p.getIdClient());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
               if(p.getEmail()!=null){
                    q.get().setEmail(p.getEmail());
                }
                if(p.getAge()!=null){
                    q.get().setAge(p.getAge());
                }
                if(p.getPassword()!=null){
                    q.get().setPassword(p.getPassword());
                }
                usureposit.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }

    public void jsontraer(){
       // System.out.println((ArrayList<usuario>) usureposit.findAll());
        List<usuario> lista=(List<usuario>) usureposit.findAll();
        ArrayList g=null;
        for(usuario x:lista){
            g.add(x.getIdClient());
            g.add(x.getName());
            g.add(x.getAge());
            g.add(x.getPassword());
            g.add(x.getReservations());
        }
        ObjectMapper mapper=new ObjectMapper();
        /*try{
            usuario x=mapper.readValue(persona,usuario.class);
        }
        catch(){

        }*/
    }


    public boolean eliminar(Integer Id){
        try{
            usureposit.deleteById(Id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
