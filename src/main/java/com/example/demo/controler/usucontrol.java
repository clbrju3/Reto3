package com.example.demo.controler;
import com.example.demo.model.Conteo;
import com.example.demo.model.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.servides.ususervi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class usucontrol {
    @Autowired
    ususervi usu;
    @GetMapping(path="/all")
    public ArrayList<usuario> get() {
        return usu.resultado();
    }
    @PostMapping(path="/save")
    @ResponseStatus(HttpStatus.CREATED)
    public usuario Guardar(@RequestBody usuario x) {
        return usu.guardar(x);
}
    @PutMapping(path="/update")
    @ResponseStatus(HttpStatus.CREATED)
    public usuario Actualizar(@RequestBody usuario x){
        return usu.actualizar(x);
    }
   @GetMapping(path ="/{Id}")
    public Optional<usuario> ObtenerId(@PathVariable("Id") Integer Id){
    return this.usu.ObtenerporId(Id);
   }
   @DeleteMapping(path="/{Id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer borrarporId(@PathVariable("Id") Integer Id){
        this.usu.eliminar(Id);
        return Id;
   }
}


