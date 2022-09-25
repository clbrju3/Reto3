package com.example.demo.servides;

import com.example.demo.model.Bicicleta;
import com.example.demo.model.Categoria;
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

    public boolean eliminar(Integer Id){
        try{
            Bicirepo.deleteById(Id);
            return true;
        }
        catch (Exception e){
            return false;}}
}

