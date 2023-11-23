package com.example.encuesta_restaurante.mapping;

import com.example.encuesta_restaurante.dto.EncuestasDTO;
import com.example.encuesta_restaurante.entity.ClienteEntity;
import com.example.encuesta_restaurante.entity.EncuestaEntity;
import com.example.encuesta_restaurante.util.LocalDateFormatter;

import java.util.ArrayList;
import java.util.List;

public class EncuestaMapping {

    public EncuestaEntity encuestaDtoToEncuestaEntity (EncuestasDTO encuestaDTO)
    {
        return EncuestaEntity.builder()
                .id(encuestaDTO.getIdEncuesta())
                .clienteIdCliente(ClienteEntity.builder().id(encuestaDTO.getIdClienteEntity()).build())
                .titulo(encuestaDTO.getTitulo())
                .fecha(new LocalDateFormatter().dateStringToLocalDate(encuestaDTO.getFecha()))
                .build();
    }

    public EncuestasDTO encuestaEntityToEncuestaDTO (EncuestaEntity encuestasEntity)
    {
        return EncuestasDTO.builder()
                .idEncuesta(encuestasEntity.getId())
                .idClienteEntity(encuestasEntity.getClienteIdCliente().getId())
                .titulo(encuestasEntity.getTitulo())
                .fecha(new LocalDateFormatter().LocalDateToStringDate(encuestasEntity.getFecha()))
                .build();
    }


    public List<EncuestasDTO> listEncuestaEntityToEncuestaDTO(List<EncuestaEntity> entities)
    {
        List<EncuestasDTO> encuestasDTOs = new ArrayList<>();
        entities.forEach(encuestaEntity-> {
            EncuestasDTO encuestasDTO= encuestaEntityToEncuestaDTO(encuestaEntity);
            encuestasDTOs.add(encuestasDTO);
        });
        return encuestasDTOs;
    }
}
