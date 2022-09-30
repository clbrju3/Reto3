package com.example.demo.repository;

import com.example.demo.model.Bicicleta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
    public interface Bicirepo extends CrudRepository<Bicicleta, Integer> {
    public abstract ArrayList<Bicicleta> findByNombre(String Nombre);
    }

