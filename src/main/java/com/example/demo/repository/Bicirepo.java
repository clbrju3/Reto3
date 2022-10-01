package com.example.demo.repository;

import com.example.demo.model.Bicicleta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface Bicirepo extends CrudRepository<Bicicleta, Integer> {
    
    }

