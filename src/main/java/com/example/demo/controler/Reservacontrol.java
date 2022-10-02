package com.example.demo.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Reserva;
import com.example.demo.servides.Reservaservi;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class Reservacontrol {

    @Autowired
    Reservaservi reservasService;

    @GetMapping("/all")
    public List<Reserva> getAll(){
        return reservasService.getAll();
    }
    @PostMapping(path="/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody  Reserva p){
        return reservasService.save(p);
    }
}