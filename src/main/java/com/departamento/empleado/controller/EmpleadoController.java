package com.departamento.empleado.controller;

import com.departamento.empleado.dto.ResponseDto;
import com.departamento.empleado.dto.RespuestaDto;
import com.departamento.empleado.service.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmpleadoController {
    @Autowired
    EmpleadoService service;

    @GetMapping("/deparments/{deparment}")
    public ResponseEntity<RespuestaDto> mediaSalario(@PathVariable String deparment) {
        return ResponseEntity.ok(service.findByDeparment(deparment));
    }
    @GetMapping("/empleados")
    ResponseEntity<List<ResponseDto>> obtenerEmpleados() {
        return ResponseEntity.ok(service.obtenerEmpleados());
    }
}
