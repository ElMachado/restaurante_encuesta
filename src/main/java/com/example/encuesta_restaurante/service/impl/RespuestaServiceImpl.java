package com.example.encuesta_restaurante.service.impl;

import com.example.encuesta_restaurante.dto.RespuestasDTO;
import com.example.encuesta_restaurante.entity.RespuestaEntity;
import com.example.encuesta_restaurante.mapping.RespuestasMapping;
import com.example.encuesta_restaurante.repository.IRespuestaRepository;
import com.example.encuesta_restaurante.service.IrespuestasClientesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@AllArgsConstructor
@Service
public class RespuestaServiceImpl implements IrespuestasClientesService {
    private final IRespuestaRepository iRespuestaRepository;
    @Override
    public RespuestasDTO crearRespuestaCliente(RespuestasDTO respuestasDTO) {
        Optional<RespuestaEntity> buscarRespuestacliente = iRespuestaRepository.findById(respuestasDTO.getId());
        if (!Objects.isNull(buscarRespuestacliente))
        {
            RespuestaEntity respuestasEntity = iRespuestaRepository.saveAndFlush(new RespuestasMapping().respuestaClienteDtoToRespuestaClienteEntity(respuestasDTO));
            if (Objects.nonNull(respuestasEntity))
            {
                return new RespuestasMapping().respuestasClientesEntityToRespuestaClientesDto(respuestasEntity);
            }
        }
        return null;
    }

    @Override
    public RespuestasDTO actualizarRespuestaCliente(RespuestasDTO respuestasDTO) {
        Optional<RespuestaEntity> buscarRespuestaCliente= iRespuestaRepository.findById(respuestasDTO.getId());
        if (Objects.nonNull(buscarRespuestaCliente.get()))
        {
            RespuestaEntity actualizarRespuestCliente= iRespuestaRepository.saveAndFlush(new RespuestasMapping().respuestaClienteDtoToRespuestaClienteEntity(respuestasDTO));
            if (Objects.nonNull(actualizarRespuestCliente))
            {
                RespuestasDTO preguntaActualizada= new RespuestasMapping().respuestasClientesEntityToRespuestaClientesDto(actualizarRespuestCliente);
                return preguntaActualizada;
            }
        }
        return null;
    }

    @Override
    public RespuestasDTO buscarRespuestaCliente(Integer idRespuestasClientes) {
        Optional<RespuestaEntity> buscarRespuestaCliente= iRespuestaRepository.findById(idRespuestasClientes);
        if (Objects.nonNull(buscarRespuestaCliente.get()))
        {
            RespuestasDTO buscarRespuestCliente= new RespuestasMapping().respuestasClientesEntityToRespuestaClientesDto(buscarRespuestaCliente.get());
            return buscarRespuestCliente;
        }
        return null;
    }

    @Override
    public String borrarRespuestaCliente(RespuestasDTO respuestasDTO) {
        RespuestasDTO buscarRespuestaCliente= buscarRespuestaCliente(respuestasDTO.getId());
        if (Objects.nonNull(buscarRespuestaCliente))
        {
            iRespuestaRepository.delete(new RespuestasMapping().respuestaClienteDtoToRespuestaClienteEntity(respuestasDTO));
            return "¡La pregunta fue borrada con exito";
        }
        return null;
    }

    @Override
    public List<RespuestasDTO> buscarTodasLasRespuestasCliente() {
        List<RespuestaEntity> respuestasClienteEntities= iRespuestaRepository.findAll();
        if (!respuestasClienteEntities.isEmpty()&& respuestasClienteEntities.size()>0)
        {
            List<RespuestasDTO> respuestasDTOS = new RespuestasMapping().listRespuestaClienteEntitiesToRespuestaClienteDTOs(respuestasClienteEntities);
            return respuestasDTOS;
        }
        return null;
    }
}
