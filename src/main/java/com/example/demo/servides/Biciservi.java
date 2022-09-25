package com.example.demo.servides;

import com.example.demo.model.Bicicleta;
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
    public ArrayList<Bicicleta> Obtenerpornombre(String Id) {

        return Bicirepo.findByNombre(Id);
    }
    public boolean eliminar(Integer Id){
        try{
            Bicirepo.deleteById(Id);
            return true;
        }
        catch (Exception e){
            return false;}}
}
