package com.example.encuesta_restaurante.service.impl;

import com.example.encuesta_restaurante.dto.PreguntasDTO;
import com.example.encuesta_restaurante.entity.PreguntaEntity;
import com.example.encuesta_restaurante.mapping.PreguntasMapping;
import com.example.encuesta_restaurante.repository.IPreguntasRepository;
import com.example.encuesta_restaurante.service.IpreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PreguntaServiceImpl implements IpreguntaService {
    private final IPreguntasRepository iPreguntasRepository;

    @Override
    public PreguntasDTO crearPreguntas(PreguntasDTO preguntasDTO) {
        try {
            Optional<PreguntaEntity> buscarPregunta = iPreguntasRepository.findById(preguntasDTO.getId());

            if (Objects.isNull(buscarPregunta)) {
                throw new RuntimeException("Ya se encuentra registrado esta pregunta");
            }
            PreguntaEntity preguntaEntity = iPreguntasRepository.saveAndFlush(new PreguntasMapping().preguntasDtoToPreguntasEntity(preguntasDTO));
            return new PreguntasMapping().preguntasEntityToPreguntasDTO(preguntaEntity);
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        }
    }

    @Override
    public PreguntasDTO actualizarPreguntas(PreguntasDTO preguntasDTO) {
        try {
            Optional<PreguntaEntity> buscarPregunta = iPreguntasRepository.findById(preguntasDTO.getId());
            if (buscarPregunta.isEmpty()) {
                throw new RuntimeException("No se encontró la pregunta.");
            }
            PreguntaEntity actualizarPregunta = iPreguntasRepository.saveAndFlush(new PreguntasMapping().preguntasDtoToPreguntasEntity(preguntasDTO));
            PreguntasDTO preguntaActualizada = new PreguntasMapping().preguntasEntityToPreguntasDTO(actualizarPregunta);
            return preguntaActualizada;
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        }
    }

    @Override
    public PreguntasDTO buscarPreguntas(Integer idPregunta) {
        try {
            Optional<PreguntaEntity> buscarPregunta = iPreguntasRepository.findById(idPregunta);
            if (buscarPregunta.isEmpty()) {
                throw new RuntimeException("No se encontró la pregunta");
            }
            PreguntasDTO buscarPreguntaDto = new PreguntasMapping().preguntasEntityToPreguntasDTO(buscarPregunta.get());
            return buscarPreguntaDto;
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        }
    }

    @Override
    public String borrarPreguntas(PreguntasDTO preguntasDTO) {
      try {
          PreguntasDTO buscarPregunta = buscarPreguntas(preguntasDTO.getId());
          if (Objects.nonNull(buscarPregunta)) {
              throw new RuntimeException("No se encontró la pregunta");
          }
          iPreguntasRepository.delete(new PreguntasMapping().preguntasDtoToPreguntasEntity(preguntasDTO));
          return "¡La pregunta fue borrada con exito";
      }catch (RuntimeException runtimeException)
      {
          throw new RuntimeException(runtimeException.getMessage());

      }
    }

    @Override
    public List<PreguntasDTO> buscarTodasLasPreguntas() {
        try {
            List<PreguntaEntity> preguntaEntities = iPreguntasRepository.findAll();
            if (preguntaEntities.isEmpty()) {
                throw new RuntimeException("La lista se encuentra vacia!");
            }
            List<PreguntasDTO> preguntasDTOS = new PreguntasMapping().listPreguntaEntitiesToPreguntaDtos(preguntaEntities);
            return preguntasDTOS;
        }catch (RuntimeException runtimeException)
        { throw new RuntimeException(runtimeException.getMessage());}
    }
}
