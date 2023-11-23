package com.example.encuesta_restaurante.service;

import com.example.encuesta_restaurante.dto.EncuestasDTO;

import java.util.List;

public interface IencuestaService {
    EncuestasDTO crearEncuesta(EncuestasDTO encuestasDTO);

    EncuestasDTO actualizarEncuesta(EncuestasDTO encuestasDTO);


    EncuestasDTO buscarEncuesta(Integer idEncuesta);

    String borrarEncuesta(EncuestasDTO encuestasDTO);
    List<EncuestasDTO> buscarTodasLasEncuestas();
}
