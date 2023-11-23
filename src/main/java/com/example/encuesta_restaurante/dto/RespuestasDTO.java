package com.example.encuesta_restaurante.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RespuestasDTO {
    private int id;
    @JsonProperty("preguntas_id_preguntas")
    private Integer idPregunta;
    @JsonProperty("respuesta_texto")
    private String respuestaTexto;

}
