package com.example.demo.controler;

import com.example.demo.model.Bicicleta;
import com.example.demo.servides.Biciservi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
@RestController
@RequestMapping("/api/Bike")
public class Bicicontroler {
        @Autowired
        Biciservi usu;

        @GetMapping(path="/all")
        public ArrayList<Bicicleta> get() {
            System.out.println("Jajasalu2");
            return usu.resultado();
        }
        @PostMapping(path="/save")
        @ResponseStatus(HttpStatus.CREATED)
        public Bicicleta Guardar(@RequestBody Bicicleta x) {
            return usu.guardar(x);
        }
        @PutMapping(path="/update")
        @ResponseStatus(HttpStatus.CREATED)
        public Bicicleta Actualizar(@RequestBody Bicicleta x){return usu.actualizar(x);}
        @GetMapping(path ="/{Id}")
        public Optional<Bicicleta> ObtenerId(@PathVariable("Id") Integer Id){
            return this.usu.ObtenerporId(Id);
        }
        @DeleteMapping(path="/{Id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public Integer borrarporId(@PathVariable("Id") Integer Id){
            this.usu.eliminar(Id);
            return Id;
        }
    }

