package com.example.demo.repository;

import com.example.demo.model.Mensaje;
import com.example.demo.model.usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mensarepo extends CrudRepository<Mensaje, Integer> {

}
