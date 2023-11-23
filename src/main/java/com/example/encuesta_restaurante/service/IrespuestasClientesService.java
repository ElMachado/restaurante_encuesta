package com.example.encuesta_restaurante.service;

import com.example.encuesta_restaurante.dto.RespuestasDTO;

import java.util.List;

public interface IrespuestasClientesService {

    RespuestasDTO crearRespuestaCliente(RespuestasDTO respuestasDTO);

    RespuestasDTO actualizarRespuestaCliente(RespuestasDTO respuestasDTO);


    RespuestasDTO buscarRespuestaCliente(Integer idRespuestasClientes);

    String borrarRespuestaCliente(RespuestasDTO respuestasDTO);
    List<RespuestasDTO> buscarTodasLasRespuestasCliente();
}
