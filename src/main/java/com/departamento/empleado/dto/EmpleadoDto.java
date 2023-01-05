package com.departamento.empleado.dto;

public class EmpleadoDto {

    private String nombre;

    private String apellido;

    private double salario;

    public EmpleadoDto(String nombre, String apellido, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSalario() {
        return salario;
    }
}
