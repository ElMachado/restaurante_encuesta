package com.example.encuesta_restaurante.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO{
    @JsonProperty("id_cliente")
    private Integer idCliente;
    private String nombre;
    private String email;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDTO that = (ClienteDTO) o;
        return idCliente == that.idCliente && Objects.equals(nombre, that.nombre) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nombre, email);
    }

}
