package com.departamento.empleado.dto;

public class RespuestaDto {

    private double media;

    private double salarioMaximo;
    private EmpleadosDto empleados;

    public RespuestaDto(double media, EmpleadosDto empleados) {
        this.media = media;
        this.empleados = empleados;
    }

    public double getMedia() {
        return media;
    }

    public EmpleadosDto getEmpleados() {
        return empleados;
    }

}
