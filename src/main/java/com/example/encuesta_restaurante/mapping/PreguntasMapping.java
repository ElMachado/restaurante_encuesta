package com.example.encuesta_restaurante.mapping;

import com.example.encuesta_restaurante.dto.PreguntasDTO;
import com.example.encuesta_restaurante.entity.EncuestaEntity;
import com.example.encuesta_restaurante.entity.PreguntaEntity;
import com.example.encuesta_restaurante.entity.RespuestaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.EnumSet.range;

public class PreguntasMapping {

    public PreguntaEntity preguntasDtoToPreguntasEntity(PreguntasDTO preguntasDTO) {

        return PreguntaEntity.builder()
                .id(preguntasDTO.getId())
                .encuestasIdEncuesta(EncuestaEntity.builder().id(preguntasDTO.getIdEncuesta()).build())
                .tipoPregunta((String) preguntasDTO.getTipoPregunta())
                .preguntaTexto(preguntasDTO.getPreguntaTexto())
                .respuestas(preguntasDTO.getRespuestaIdRespuesta())
                .build();
    }

    public PreguntasDTO preguntasEntityToPreguntasDTO(PreguntaEntity preguntasEntity) {

        return PreguntasDTO.builder()
                .id(preguntasEntity.getId())
                .idEncuesta(preguntasEntity.getEncuestasIdEncuesta().getId())
                .tipoPregunta(preguntasEntity.getTipoPregunta())
                .preguntaTexto(preguntasEntity.getPreguntaTexto())
                .respuestaIdRespuesta(preguntasEntity.getRespuestas())
                .build();
    }

    public List<PreguntasDTO> listPreguntaEntitiesToPreguntaDtos(List<PreguntaEntity> preguntaEntities) {
        List<PreguntasDTO> preguntasDTOs = new ArrayList<>();
        preguntaEntities.forEach(preguntaEntity -> {
            PreguntasDTO preguntasDTO = preguntasEntityToPreguntasDTO(preguntaEntity);
            preguntasDTOs.add(preguntasDTO);
        });
        return preguntasDTOs;
    }


}
