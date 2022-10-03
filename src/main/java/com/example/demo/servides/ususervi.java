package com.example.demo.servides;

import org.hibernate.boot.model.source.spi.SizeSource;
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
        usuario x=ObtenerporId(usua.getIdClient()).get();
        if(usua.getName().isEmpty()){
            usua.setName(x.getName());
        }
        if(usua.getEmail().isEmpty()){
            usua.setEmail(x.getEmail());
        }
        if(usua.getPassword().isEmpty()){
            usua.setPassword(x.getPassword());
        }
        if(usua.getAge()==null){
            usua.setAge(x.getAge());
        }
        if(usua.getMessages().isEmpty()){
            usua.setMessages(x.getMessages());
        }
        if(usua.getReservations().isEmpty()){
            usua.setReservations(x.getReservations());
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
