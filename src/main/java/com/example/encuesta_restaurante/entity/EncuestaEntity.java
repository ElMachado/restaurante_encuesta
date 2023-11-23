package com.example.encuesta_restaurante.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "encuestas", schema = "restaurante_encuesta", indexes = {
        @Index(name = "fk_encuestas_cliente1_idx", columnList = "cliente_id_cliente")
})
public class EncuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encuesta", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 45)
    private String titulo;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id_cliente", nullable = false)
    private ClienteEntity clienteIdCliente;

    @OneToMany(mappedBy = "encuestasIdEncuesta")
    private List<PreguntaEntity> preguntas;

}