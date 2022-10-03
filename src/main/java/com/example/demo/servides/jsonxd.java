package com.example.demo.servides;

import com.example.demo.model.Bicicleta;
import com.example.demo.model.Reserva;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value="/jsonp")
public class jsonxd{

        public String jsonp(Object p){

        ObjectMapper mapper = new ObjectMapper();
        String json="";

        try {
        json = mapper.writeValueAsString(p);

        } catch (JsonProcessingException e) {
        e.printStackTrace();
        }

        //String jsonpString="data={'one':1,'two':2,'three':3};";
        return json;
        }}
