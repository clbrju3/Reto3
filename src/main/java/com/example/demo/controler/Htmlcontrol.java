package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Htmlcontrol {
        @GetMapping("Vistas/mensage.html")
        public String mensage() {
            return "Vistas/html/mensage";
        }
    @GetMapping("Vistas/bicicleta.html")
    public String bici() {
        return "Vistas/html/bicicleta";
    }
    @GetMapping("Vistas/cliente.html")
    public String cliente() {
        return "/Vistas/hmtl/cliente";
    }

    }


