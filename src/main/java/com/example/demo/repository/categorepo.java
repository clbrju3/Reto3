package com.example.demo.repository;

import com.example.demo.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categorepo extends CrudRepository<Categoria,Integer> {
}
