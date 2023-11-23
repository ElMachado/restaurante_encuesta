package com.example.encuesta_restaurante.service.impl;

import com.example.encuesta_restaurante.dto.EncuestasDTO;
import com.example.encuesta_restaurante.entity.EncuestaEntity;
import com.example.encuesta_restaurante.mapping.EncuestaMapping;
import com.example.encuesta_restaurante.repository.IEncuestaRepository;
import com.example.encuesta_restaurante.service.IencuestaService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Builder
public class EncuestaServiceImpl implements IencuestaService {
    private final IEncuestaRepository iEncuestaRepository;

    @Override
    public EncuestasDTO crearEncuesta(EncuestasDTO encuestasDTO) {
        try {
            Optional<EncuestaEntity> buscarEncuesta = iEncuestaRepository.findByIdEncuesta(encuestasDTO.getIdEncuesta());

            if (!Objects.nonNull(buscarEncuesta)) {
                throw new RuntimeException("Ya se encuentra registrada esta encuesta");
            }
            EncuestaEntity encuestaEntity = iEncuestaRepository.saveAndFlush(new EncuestaMapping().encuestaDtoToEncuestaEntity(encuestasDTO));

            return new EncuestaMapping().encuestaEntityToEncuestaDTO(encuestaEntity);

        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        }
    }

    @Override
    public EncuestasDTO actualizarEncuesta(EncuestasDTO encuestasDTO) {
        try {
            Optional<EncuestaEntity> buscarEncuesta = iEncuestaRepository.findByIdEncuesta(encuestasDTO.getIdEncuesta());

            if (!buscarEncuesta.isPresent()) {
                throw new RuntimeException("No se encontró la encuesta");
            }
            EncuestaEntity actualizarEncuesta = iEncuestaRepository.saveAndFlush(new EncuestaMapping().encuestaDtoToEncuestaEntity(encuestasDTO));
            EncuestasDTO actualizarEncuestaDto = new EncuestaMapping().encuestaEntityToEncuestaDTO(actualizarEncuesta);
            return actualizarEncuestaDto;
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        }
    }

    @Override
    public EncuestasDTO buscarEncuesta(Integer idEncuesta) {

        try {
            Optional<EncuestaEntity> buscarEncuesta = iEncuestaRepository.findByIdEncuesta(idEncuesta);
            if (!buscarEncuesta.isPresent()) {
                throw new RuntimeException("No se encontró el Cliente");
            }

            EncuestasDTO buscarEncuestaDto = new EncuestaMapping().encuestaEntityToEncuestaDTO(buscarEncuesta.get());
            return buscarEncuestaDto;


        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        }
    }

    @Override
    public String borrarEncuesta(EncuestasDTO encuestasDTO) {
        try {
            Optional<EncuestaEntity> buscarEncuesta = iEncuestaRepository.findByIdEncuesta(encuestasDTO.getIdEncuesta());
            if (buscarEncuesta.isEmpty()) {
                throw new RuntimeException("No se encontró el Cliente");
            }
            iEncuestaRepository.delete(new EncuestaMapping().encuestaDtoToEncuestaEntity(encuestasDTO));
            return "¡La encuesta fue borrada con exito!";
        }catch (RuntimeException runtimeException){
            throw new RuntimeException(runtimeException.getMessage());
        }
    }

    @Override
    public List<EncuestasDTO> buscarTodasLasEncuestas() {
        try {
            List<EncuestaEntity> encuestaEntities = iEncuestaRepository.findAll();
            if (encuestaEntities.isEmpty()) {
                throw new RuntimeException("La lista se encuentra vacia!");
            }
            List<EncuestasDTO> encuestasDTOList = new EncuestaMapping().listEncuestaEntityToEncuestaDTO(encuestaEntities);
            return encuestasDTOList;
        }catch (RuntimeException runtimeException)
        {throw new RuntimeException(runtimeException.getMessage());}
    }
}
