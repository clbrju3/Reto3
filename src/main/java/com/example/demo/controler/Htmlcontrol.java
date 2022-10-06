package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("http://140.84.191.220:8080")
public class Htmlcontrol {
    @GetMapping("/")
    public String index(){
        return "<h2>Index</h2>";
    }
        @GetMapping("/Vistas/mensage.html")
        public String mensage() {
            return "Vistas/html/mensage";
        }
    @GetMapping("/Vistas/bicicleta.html")
    public String bici() {
        return "Vistas/html/bicicleta";
    }
    @GetMapping("/Vistas/cliente.html")
    public String cliente() {
        return "Vistas/hmtl/cliente";
    }

    }


