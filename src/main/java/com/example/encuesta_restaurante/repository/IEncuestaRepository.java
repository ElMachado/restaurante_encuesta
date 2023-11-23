package com.example.encuesta_restaurante.repository;

import com.example.encuesta_restaurante.entity.EncuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IEncuestaRepository extends JpaRepository<EncuestaEntity,Integer> {
    @Query("select e from EncuestaEntity e where e.id=:idEncuesta")
    Optional<EncuestaEntity> findByIdEncuesta(Integer idEncuesta);
}
