package com.example.encuesta_restaurante.service;

import com.example.encuesta_restaurante.dto.ClienteDTO;

import java.util.List;

public interface IclienteService {
     ClienteDTO crearCliente(ClienteDTO clienteDTO);

    ClienteDTO actualizarCliente(ClienteDTO clienteDTO);

    ClienteDTO buscarCliente(Integer idCliente);
    String borrarCliente(ClienteDTO clienteDTO);
    List<ClienteDTO> buscarTodosLosClientes();
}
