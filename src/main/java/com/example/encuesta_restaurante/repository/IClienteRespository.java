package com.example.encuesta_restaurante.repository;

import com.example.encuesta_restaurante.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IClienteRespository extends JpaRepository<ClienteEntity,Integer> {

    @Query("select e from ClienteEntity e where e.nombre=:nombre")
    ClienteEntity findByNombre(String nombre);


}
