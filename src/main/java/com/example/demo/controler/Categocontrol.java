package com.example.demo.controler;

import com.example.demo.model.Bicicleta;
import com.example.demo.model.Categoria;
import com.example.demo.servides.Biciservi;
import com.example.demo.servides.Categoservi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class Categocontrol {
    @Autowired
    Categoservi usu;

    @GetMapping("/all")
    public ArrayList<Categoria> get() {
        return usu.resultado();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria Guardar(@RequestBody Categoria x) {
        return usu.guardar(x);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria Actualizar(@RequestBody Categoria x){return usu.actualizar(x);}
    @GetMapping(path ="/{Id}")
    public Optional<Categoria> ObtenerId(@PathVariable("Id") Integer Id){
        return this.usu.ObtenerporId(Id);
    }
    @DeleteMapping(path="/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer borrarporId(@PathVariable("Id") Integer Id){
        this.usu.eliminar(Id);
        return Id;}

}
