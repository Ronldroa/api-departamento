package com.departamento.empleado.dto;

import java.util.List;

public class EmpleadosDto {

    private List<EmpleadoDto> superior;
    private List<EmpleadoDto> inferior;

    public EmpleadosDto(List<EmpleadoDto> superior, List<EmpleadoDto> inferior) {
        this.superior = superior;
        this.inferior = inferior;
    }

    public List<EmpleadoDto> getSuperior() {
        return superior;
    }

    public List<EmpleadoDto> getInferior() {
        return inferior;
    }
}
