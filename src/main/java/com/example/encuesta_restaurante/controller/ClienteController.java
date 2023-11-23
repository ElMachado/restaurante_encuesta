package com.example.encuesta_restaurante.controller;

import com.example.encuesta_restaurante.dto.ClienteDTO;
import com.example.encuesta_restaurante.service.IclienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/restauranteEncuesta/clientes")
@CrossOrigin(origins = "*")
@Log4j2
public class ClienteController {
    private final IclienteService iclienteService;

    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = ClienteDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearCliente(@RequestBody @Validated ClienteDTO clienteDTO){
        ClienteDTO clienteResponse= iclienteService.crearCliente(clienteDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(clienteResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = ClienteDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @PutMapping (produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> actualizarCliente(@RequestBody @Validated ClienteDTO clienteDTO){
        ClienteDTO clienteResponse= iclienteService.actualizarCliente(clienteDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(clienteResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = ClienteDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarCliente(@RequestBody @Validated ClienteDTO clienteDTO){
        ClienteDTO clienteResponse= iclienteService.buscarCliente(clienteDTO.getIdCliente());
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(clienteResponse));
        }catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = ClienteDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @RequestMapping("/all")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarTodosLosClientes(){
        List<ClienteDTO> listaClientesResponse= iclienteService.buscarTodosLosClientes();
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(listaClientesResponse));
        }catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = ClienteDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarCliente(@RequestBody @Validated ClienteDTO clienteDTO)
    {
        String clienteResponse= iclienteService.borrarCliente(clienteDTO);

        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteResponse);

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }



}
