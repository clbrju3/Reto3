package com.example.demo.servides;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.usuario;
import com.example.demo.repository.usureposit;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ususervi {
    @Autowired
    usureposit usureposit;

    public ArrayList<usuario> resultado(){
     return (ArrayList<usuario>) usureposit.findAll();
    }
    public usuario guardar(usuario usua){
        return usureposit.save(usua);
    }
    public Optional<usuario> ObtenerporId(Integer Id) {
        return usureposit.findById(Id);
    }
    public usuario actualizar(usuario usua){
        Optional<usuario> x=ObtenerporId(usua.getIdClient());
        if(x.isEmpty()){
            System.out.println("xd");
        }
        else{
        usuario y=x.get();
        if(usua.getName()==null){
            usua.setName(y.getName());
        }
        if(usua.getEmail()==null){
            usua.setEmail(y.getEmail());
        }
        if(usua.getPassword()==null){
            usua.setPassword(y.getPassword());
        }
        if(usua.getAge()==null){
            usua.setAge(y.getAge());
        }
        if(usua.getMessages().isEmpty()){
            usua.setMessages(y.getMessages());
        }
        if(usua.getReservations().isEmpty()){
            usua.setReservations(y.getReservations());
        }
        
    }

    return usureposit.save(usua);

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
