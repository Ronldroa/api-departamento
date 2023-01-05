package com.departamento.empleado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ResponseDto {

    private String nombre;
    private String apellido;
    private String email;
    @JsonProperty("al-reves")
    private String alReves;

    public ResponseDto(String nombre, String apellido, String email, String alReves) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.alReves = alReves;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getAlReves() {
        return alReves;
    }
}
