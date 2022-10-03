package com.example.demo.servides;

import com.example.demo.model.Bicicleta;
import com.example.demo.model.Categoria;
import com.example.demo.model.usuario;
import com.example.demo.repository.Bicirepo;
import com.example.demo.repository.categorepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class Categoservi {
    @Autowired
    categorepo Bicirepo;

    public ArrayList<Categoria> resultado(){
        return (ArrayList<Categoria>) Bicirepo.findAll();
    }
    public Categoria guardar(Categoria usua){

        return Bicirepo.save(usua);
    }
    public Optional<Categoria> ObtenerporId(Integer Id) {

        return Bicirepo.findById(Id);
    }
    public Categoria actualizar(Categoria p){
        if(p.getId()!=null){
            Optional<Categoria> q = ObtenerporId(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
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

