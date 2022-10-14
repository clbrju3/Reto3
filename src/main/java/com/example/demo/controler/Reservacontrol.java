package com.example.demo.controler;


import com.example.demo.model.Bicicleta;
import com.example.demo.model.Completo;
import com.example.demo.model.Conteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Reserva;
import com.example.demo.servides.Reservaservi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class Reservacontrol {


    @Autowired
    Reservaservi reservasService;
    @GetMapping(path = "/report-dates/{date1}/{date2}")
    public List<Reserva> ordenarreservas(@PathVariable("date1") String date1, @PathVariable("date2") String date2){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date11=null;
        java.sql.Date date22=null;
        try {
            Date parsed =  dateFormat.parse(date1);
            date11 = new java.sql.Date(parsed.getTime());
        } catch(Exception e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
        try {
            Date parsed =  dateFormat.parse(date2);
            date22 = new java.sql.Date(parsed.getTime());
        } catch(Exception e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
        if(date1.compareTo(date2)<0){
        return reservasService.EncontrarReservas(date11,date22);}
        else{
            return null;
        }
    }
    @GetMapping(path="/report-clients")
    public List<Conteo> contar(){
        return reservasService.Conteo();
    }
    @GetMapping("/report-status")
    public Completo Reporteclientes(){
        return reservasService.Reporte();
    }

    @GetMapping("/all")
    public List<Reserva> getAll(){
        return reservasService.getAll();
    }
    @PostMapping(path="/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody  Reserva p){
        return reservasService.save(p);
    }
    @PutMapping(path="/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva actualizar(@RequestBody Reserva p){return reservasService.actualizar(p);
}
    @GetMapping(path ="/{Id}")
    public Optional<Reserva> ObtenerId(@PathVariable("Id") Integer Id){
        return this.reservasService.getReservas(Id);
    }
    @DeleteMapping(path="/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer borrarporId(@PathVariable("Id") Integer Id){
        this.reservasService.delete(null);
        return Id;}}