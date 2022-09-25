package com.example.demo.repository;
import com.example.demo.model.Bicicleta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.usuario;
import javax.persistence.*;
import java.util.ArrayList;

@Repository
public interface usureposit extends CrudRepository<usuario, Integer>{

}


