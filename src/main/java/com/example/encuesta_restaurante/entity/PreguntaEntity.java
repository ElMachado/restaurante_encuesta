package com.example.encuesta_restaurante.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "preguntas", schema = "restaurante_encuesta", indexes = {
        @Index(name = "fk_preguntas_encuestas1_idx", columnList = "encuestas_id_encuesta")
})
public class PreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preguntas", nullable = false)
    private Integer id;

    @Column(name = "pregunta_texto", nullable = false, length = 150)
    private String preguntaTexto;

    @Lob
    @Column(name = "tipo_pregunta", nullable = false)
    private String tipoPregunta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "encuestas_id_encuesta", nullable = false)
    private EncuestaEntity encuestasIdEncuesta;

    @OneToMany(mappedBy = "preguntasIdPreguntas")
    private List<RespuestaEntity> respuestas = new ArrayList<RespuestaEntity>();

}