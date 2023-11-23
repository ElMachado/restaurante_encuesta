package com.example.encuesta_restaurante.mapping;

import com.example.encuesta_restaurante.dto.RespuestasDTO;
import com.example.encuesta_restaurante.entity.PreguntaEntity;
import com.example.encuesta_restaurante.entity.RespuestaEntity;

import java.util.ArrayList;
import java.util.List;

public class RespuestasMapping {

    public RespuestaEntity respuestaClienteDtoToRespuestaClienteEntity (RespuestasDTO respuestasDTO)
    {
        return RespuestaEntity.builder()
                .id(respuestasDTO.getId())
                .preguntasIdPreguntas(PreguntaEntity.builder().id(respuestasDTO.getIdPregunta()).build())
                .respuestaTexto(respuestasDTO.getRespuestaTexto())
                .build();

    }
    public RespuestasDTO respuestasClientesEntityToRespuestaClientesDto(RespuestaEntity respuestaEntity)
    {
        return RespuestasDTO.builder()
                .id(respuestaEntity.getId())
                .idPregunta(respuestaEntity.getPreguntasIdPreguntas().getId())
                .respuestaTexto(respuestaEntity.getRespuestaTexto())
                .build();
    }

    public List<RespuestasDTO> listRespuestaClienteEntitiesToRespuestaClienteDTOs(List<RespuestaEntity> respuestasClienteEntities)
    {
        List<RespuestasDTO> respuestasDTOS = new ArrayList<>();
        respuestasClienteEntities.forEach(respuestasEntity-> {
            RespuestasDTO respuestasDTO = respuestasClientesEntityToRespuestaClientesDto(respuestasEntity);
            respuestasDTOS.add(respuestasDTO);
        });
        return respuestasDTOS;
    }
}
