package com.example.demo.servides;

import com.example.demo.model.Bicicleta;
import com.example.demo.model.usuario;
import com.example.demo.repository.Bicirepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class Biciservi {
    @Autowired
    Bicirepo Bicirepo;

    public ArrayList<Bicicleta> resultado(){
        return (ArrayList<Bicicleta>) Bicirepo.findAll();

    }
    
    public Bicicleta guardar(Bicicleta usua){

        return Bicirepo.save(usua);
    }
    public Optional<Bicicleta> ObtenerporId(Integer Id) {

        return Bicirepo.findById(Id);
    }
    public Bicicleta actualizar(Bicicleta p){
        if(p.getId()!=null){
            Optional<Bicicleta> q = ObtenerporId(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getBrand()!=null){
                    q.get().setBrand(p.getBrand());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }
                if(p.getYear()!=null){
                    q.get().setYear(p.getYear());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                Bicirepo.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean eliminar(Integer Id){
        try{
            Bicirepo.deleteById(Id);
            return true;
        }
        catch (Exception e){
            return false;}}
}
