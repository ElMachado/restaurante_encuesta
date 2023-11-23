package com.example.encuesta_restaurante.repository;

import com.example.encuesta_restaurante.entity.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IRespuestaRepository extends JpaRepository<RespuestaEntity, Integer> {
    @Query("SELECT e from RespuestaEntity e where e.id=:idRespuestaCliente")
    Optional<RespuestaEntity> findById(Integer idRespuestaCliente);
}
