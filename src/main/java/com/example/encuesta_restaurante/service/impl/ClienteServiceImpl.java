package com.example.encuesta_restaurante.service.impl;

import com.example.encuesta_restaurante.dto.ClienteDTO;
import com.example.encuesta_restaurante.entity.ClienteEntity;
import com.example.encuesta_restaurante.mapping.ClienteMapping;
import com.example.encuesta_restaurante.repository.IClienteRespository;
import com.example.encuesta_restaurante.service.IclienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IclienteService {
    private final IClienteRespository iClienteRespository;

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        try {
            ClienteEntity buscarCliente = iClienteRespository.findByNombre(clienteDTO.getNombre());
            if (Objects.isNull(buscarCliente)) {
                throw new RuntimeException("Ya se encuentra registrado este cliente");
            }
            ClienteEntity clienteEntity = iClienteRespository
                    .saveAndFlush(new ClienteMapping().clienteDtoToClienteEntity(clienteDTO));
            return new ClienteMapping().clienteEntityToClienteDTO(clienteEntity);
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        }

    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO clienteDTO) {
        try {
            Optional<ClienteEntity> buscarCliente = iClienteRespository.findById(clienteDTO.getIdCliente());
            if (!buscarCliente.isPresent()) {
                throw new RuntimeException("No se encontró el Cliente");
            }
            ClienteEntity actualizarCliente = iClienteRespository.saveAndFlush(new ClienteMapping().clienteDtoToClienteEntity(clienteDTO));

            ClienteDTO actualizarClienteDto = new ClienteMapping().clienteEntityToClienteDTO(actualizarCliente);
            return actualizarClienteDto;

        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        }
    }

    @Override
    public ClienteDTO buscarCliente(Integer idCliente) {
        try {
            Optional<ClienteEntity> buscarCliente = iClienteRespository.findById(idCliente);
            if (Objects.isNull(buscarCliente.get())) {
                throw new RuntimeException("No se encontró el Cliente");
            }
            ClienteDTO buscarClienteDTO = new ClienteMapping().clienteEntityToClienteDTO(buscarCliente.get());
            return buscarClienteDTO;
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        }
    }

    @Override
    public String borrarCliente(ClienteDTO clienteDTO) {
        try {
            Optional<ClienteEntity> buscarCliente = iClienteRespository.findById(clienteDTO.getIdCliente());
            if (!buscarCliente.isPresent()) {
                throw new RuntimeException("No se encontró el Cliente");
            }

            iClienteRespository.delete(new ClienteMapping().clienteDtoToClienteEntity(clienteDTO));
            return "¡El cliente fue borrado con exito!";
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        }
    }

    @Override
    public List<ClienteDTO> buscarTodosLosClientes() {
       try {
           List<ClienteEntity> clienteEntities = iClienteRespository.findAll();
           if (clienteEntities.isEmpty()) {
               throw new RuntimeException("La lista se encuentra vacia!");
           }
           List<ClienteDTO> clienteDTOList = new ClienteMapping().listClientesEntitiesToClienteDTO(clienteEntities);

           return clienteDTOList;
       }catch (RuntimeException runtimeException){
           throw new RuntimeException(runtimeException.getMessage());
       }
    }
}
