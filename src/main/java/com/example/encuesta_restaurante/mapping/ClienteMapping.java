package com.example.encuesta_restaurante.mapping;

import com.example.encuesta_restaurante.dto.ClienteDTO;
import com.example.encuesta_restaurante.entity.ClienteEntity;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapping {

    public ClienteEntity clienteDtoToClienteEntity(ClienteDTO clienteDTO)
    {
        return ClienteEntity.builder()
                .id(clienteDTO.getIdCliente())
                .nombre(clienteDTO.getNombre())
                .email(clienteDTO.getEmail())
                .build();
    }
    public ClienteDTO clienteEntityToClienteDTO(ClienteEntity clienteEntity)
    {
       return ClienteDTO.builder()
               .idCliente(clienteEntity.getId())
               .nombre(clienteEntity.getNombre())
               .email(clienteEntity.getEmail())
               .build();
    }

    public List<ClienteDTO> listClientesEntitiesToClienteDTO(List<ClienteEntity> entities)
    {
        List<ClienteDTO> clienteDTOS = new ArrayList<>();
        entities.forEach(clienteEntity -> {
            ClienteDTO clienteDTO = clienteEntityToClienteDTO(clienteEntity);
            clienteDTOS.add(clienteDTO);
        });
        return clienteDTOS;
    }
}
