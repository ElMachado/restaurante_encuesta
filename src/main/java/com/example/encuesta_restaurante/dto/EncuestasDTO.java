package com.example.encuesta_restaurante.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EncuestasDTO {
    @JsonProperty("id_encuesta")
    private Integer idEncuesta;
    @JsonProperty("id_cliente")
    private Integer idClienteEntity;
    private String titulo;
    private String fecha;

}
