package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Mensaje;
import com.example.demo.servides.Mensajeservi;

@RestController
@RequestMapping("/api/Message")
public class Mensajecontrol {
    @Autowired
    Mensajeservi usu;

    @GetMapping("/all")
    public List<Mensaje> get() {
        return usu.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje Guardar(@RequestBody Mensaje x) {
        return usu.save(x);
    }
@PutMapping(path="/update")
@ResponseStatus(HttpStatus.CREATED)
public Mensaje Actualizar(@RequestBody Mensaje x){
        return usu.save(x);
}
    @DeleteMapping(path="/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer borrarporId(@PathVariable("Id") Integer Id){
        this.usu.delete(null);
        return Id;}

}
