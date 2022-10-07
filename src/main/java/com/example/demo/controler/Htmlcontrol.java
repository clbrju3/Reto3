package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/")
public class Htmlcontrol {
    @GetMapping("")
   /*public String index(){
        return "Index";
    }
        @GetMapping("")*/
        public String mensage() {
            return "Vistas/html/mensage";
        }
    @GetMapping("Vistas/html/bicicleta.html")
    public String bici() {
        return "Vistas/html/bicicleta";
    }
    @GetMapping("Vistas/html/cliente.html")
    public String cliente() {
        return "Vistas/hmtl/cliente";
    }

    }


