package com.example.encuesta_restaurante.dto;

import com.example.encuesta_restaurante.entity.RespuestaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreguntasDTO {
    @JsonProperty("id_pregunta")
    private int id;
    @JsonProperty("id_encuesta")
    private Integer idEncuesta;
    @JsonProperty("pregunta_texto")
    private String preguntaTexto;
    @JsonProperty("tipo_pregunta")
    private Object tipoPregunta;
    @JsonProperty("respuesta_id_respuesta")
    private List<RespuestaEntity> respuestaIdRespuesta;

}
