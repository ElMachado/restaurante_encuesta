package com.example.encuesta_restaurante.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "respuesta", schema = "restaurante_encuesta", indexes = {
        @Index(name = "fk_respuesta_preguntas1_idx", columnList = "preguntas_id_preguntas")
})
public class RespuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta", nullable = false)
    private Integer id;

    @Column(name = "Respuesta_texto", length = 150)
    private String respuestaTexto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "preguntas_id_preguntas", nullable = false)
    private PreguntaEntity preguntasIdPreguntas;

}