package com.example.encuesta_restaurante.controller;

import com.example.encuesta_restaurante.dto.ClienteDTO;
import com.example.encuesta_restaurante.dto.EncuestasDTO;
import com.example.encuesta_restaurante.service.IencuestaService;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@RequestMapping("/restauranteEncuesta/encuesta")
@CrossOrigin(origins = "*")
@Log4j2
public class EncuestaController {
    private final IencuestaService iencuestaService;

    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = EncuestasDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearEncuesta(@RequestBody @Validated EncuestasDTO encuestasDTO){
        EncuestasDTO encuestaResponse= iencuestaService.crearEncuesta(encuestasDTO);
            try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(encuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = EncuestasDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @PutMapping (produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> actualizarEncuesta(@RequestBody @Validated EncuestasDTO encuestasDTO){
        EncuestasDTO encuestaResponse=iencuestaService.actualizarEncuesta(encuestasDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(encuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = EncuestasDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarEncuesta(@RequestBody @Validated EncuestasDTO encuestasDTO){
        EncuestasDTO encuestaResponse= iencuestaService.buscarEncuesta(encuestasDTO.getIdEncuesta());
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(encuestaResponse));
        }catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = EncuestasDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @RequestMapping("/all")
    @JsonIgnore
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarTodosLosClientes(){
        List<EncuestasDTO> listaClientesResponse= iencuestaService.buscarTodasLasEncuestas();

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(listaClientesResponse));
        }catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = EncuestasDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarCliente(@RequestBody @Validated EncuestasDTO encuestasDTO)
    {
        String encuestaResponse= iencuestaService.borrarEncuesta(encuestasDTO);

        try{
            return ResponseEntity.status(HttpStatus.OK).body(encuestaResponse);

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }



}
