package com.example.encuesta_restaurante.repository;

import com.example.encuesta_restaurante.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IPreguntasRepository extends JpaRepository<PreguntaEntity,Integer> {
   @Query("select e from PreguntaEntity e where e.id=:idPregunta")
   Optional<PreguntaEntity> findById(Integer idPregunta);

}
