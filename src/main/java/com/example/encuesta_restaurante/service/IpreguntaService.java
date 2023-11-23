package com.example.encuesta_restaurante.service;

import com.example.encuesta_restaurante.dto.PreguntasDTO;

import java.util.List;

public interface IpreguntaService {
    PreguntasDTO crearPreguntas(PreguntasDTO preguntasDTO);

    PreguntasDTO actualizarPreguntas(PreguntasDTO preguntasDTO);


    PreguntasDTO buscarPreguntas(Integer idPregunta);

    String borrarPreguntas(PreguntasDTO preguntasDTO);
    List<PreguntasDTO> buscarTodasLasPreguntas();
}
