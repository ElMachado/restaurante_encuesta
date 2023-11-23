package com.example.encuesta_restaurante.controller;

import com.example.encuesta_restaurante.dto.PreguntasDTO;
import com.example.encuesta_restaurante.service.IpreguntaService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/restauranteEncuesta/preguntas")
@CrossOrigin(origins = "*")
@Log4j2

public class PreguntaController {
    private final IpreguntaService ipreguntaService;
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = PreguntasDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearPregunta(@RequestBody @Validated PreguntasDTO preguntasDTO){
        PreguntasDTO preguntasResponse= ipreguntaService.crearPreguntas(preguntasDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(preguntasResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = PreguntasDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> actualizarPregunta(@RequestBody @Validated PreguntasDTO preguntasDTO){
        PreguntasDTO preguntasResponse=ipreguntaService.actualizarPreguntas(preguntasDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(preguntasResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = PreguntasDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarPreguntas(@RequestBody @Validated PreguntasDTO preguntasDTO){
        PreguntasDTO preguntasResponse= ipreguntaService.buscarPreguntas(preguntasDTO.getId());

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(preguntasResponse));
        }catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = PreguntasDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @RequestMapping("/all")
    @JsonIgnore
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarTodasLasPreguntas(){
        List<PreguntasDTO> listaPreguntasResponse= ipreguntaService.buscarTodasLasPreguntas();

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(listaPreguntasResponse));
        }catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

    }
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "ok. se guardo correctamente el elemento", response = PreguntasDTO.class),
            @ApiResponse(code = 400, message = "No llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")
    })
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarPregunta(@RequestBody @Validated PreguntasDTO preguntasDTO)
    {
        String preguntaResponse= ipreguntaService.borrarPreguntas(preguntasDTO);

        try{
            return ResponseEntity.status(HttpStatus.OK).body(preguntaResponse);

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
