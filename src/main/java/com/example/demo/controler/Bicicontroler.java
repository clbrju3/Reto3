package com.example.demo.controler;

import com.example.demo.model.Bicicleta;
import com.example.demo.model.usuario;
import com.example.demo.servides.Biciservi;
import com.example.demo.servides.ususervi;
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

        @GetMapping("/all")
        public ArrayList<Bicicleta> get() {
            return usu.resultado();
        }
        @PostMapping(path="/save")
        @ResponseStatus(HttpStatus.CREATED)
        public Bicicleta Guardar(@RequestBody Bicicleta x) {
            return usu.guardar(x);
        }
        @GetMapping(path="/query")
        public ArrayList<Bicicleta> ObtenerporNombre(@RequestParam("nombre") String nombre){
            return this.usu.Obtenerpornombre(nombre);
        }
        @GetMapping(path ="/{Id}")
        public Optional<Bicicleta> ObtenerId(@PathVariable("Id") Integer Id){
            return this.usu.ObtenerporId(Id);
        }
        @DeleteMapping(path="/{Id}")
        public Integer borrarporId(@PathVariable("Id") Integer Id){
            this.usu.eliminar(Id);
            return Id;
        }
    }

