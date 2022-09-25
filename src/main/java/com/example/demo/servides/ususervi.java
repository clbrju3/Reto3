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
