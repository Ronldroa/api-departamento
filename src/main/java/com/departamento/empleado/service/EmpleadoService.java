package com.departamento.empleado.service;

import com.departamento.empleado.dto.EmpleadoDto;
import com.departamento.empleado.dto.EmpleadosDto;
import com.departamento.empleado.dto.ResponseDto;
import com.departamento.empleado.dto.RespuestaDto;
import com.departamento.empleado.model.Empleado;
import com.departamento.empleado.repository.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {
    private static final Logger LOG = LoggerFactory.getLogger(EmpleadoService.class);

    private EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    /*
     * 1. Obtener todos los empleados de un departamento
     * 2. Calcular la media de los salarios
     * 3. Obtener los empleados que ganan más y menos que la media
     * 4. Devolver la media y los empleados que ganan más y menos que la media
     */
    public RespuestaDto findByDeparment(String deparment) {
        LOG.info("findByDeparment: {}", deparment);
        List<Empleado> empleados = empleadoRepository.findByDeparment(deparment);
        double media = empleados.stream().mapToDouble(Empleado::getSalary).average().orElse(0);
        List<EmpleadoDto> superior = new ArrayList<>();
        List<EmpleadoDto> inferior = new ArrayList<>();
        empleados.forEach(empleado -> {
            if (empleado.getSalary() > media) {
                superior.add(new EmpleadoDto(empleado.getFirstName(), empleado.getLastName(), empleado.getSalary()));
            } else {
                inferior.add(new EmpleadoDto(empleado.getFirstName(), empleado.getLastName(), empleado.getSalary()));
            }
        });
        return new RespuestaDto(media, new EmpleadosDto(superior, inferior));
    }


//        List<Empleado> empleados = empleadoRepository.findByDeparment(deparment);
//        double mediaSalario = averageSalary(empleados);
//        double salarioMaximo = maxSalary(empleados);
//        List<EmpleadoDto> porEncimaDeLaMedia = new ArrayList<>();
//        List<EmpleadoDto> porDebajoDeLaMedia = new ArrayList<>();
//        for (Empleado empleado : empleados) {
//            EmpleadoDto dto = new EmpleadoDto(
//                    empleado.getFirstName(),
//                    empleado.getLastName(),
//                    empleado.getSalary()
//            );
//            if (empleado.getSalary() >= mediaSalario) {
//                porEncimaDeLaMedia.add(dto);
//            } else {
//                porDebajoDeLaMedia.add(dto);
//            }
//
//        }
//        EmpleadosDto empleadosDto = new EmpleadosDto(porEncimaDeLaMedia, porDebajoDeLaMedia);
//
//        RespuestaDto respuesta = new RespuestaDto(mediaSalario, empleadosDto, salarioMaximo);
//        return respuesta;
//
//    }

    //calcular la media de los salarios
    public double averageSalary(List<Empleado> empleados) {
        double averageSalary = 0;
        for (Empleado empleado : empleados) {
            averageSalary += empleado.getSalary();
        }
        averageSalary = averageSalary / empleados.size();
        LOG.info("El salario promedio del departamento  es {}", averageSalary);
        return averageSalary;
    }

    //calcular el salario maximo
    public double maxSalary(List<Empleado> empleados) {
        double maxSalary = 0;
        for (Empleado empleado : empleados) {
            if (empleado.getSalary() > maxSalary) {
                maxSalary = empleado.getSalary();
            }
        }
        LOG.info("El salario maximo del departamento  es {}", maxSalary);
        return maxSalary;
    }

    //obtener nombre y apellido al reves
    public String obtenerNombreYApellidoAlReves(String nombre, String apellido) {
        String nombreAlReves = new StringBuilder(nombre).reverse().toString();
        String apellidoAlReves = new StringBuilder(apellido).reverse().toString();
        return nombreAlReves + " " + apellidoAlReves;

    }

    public String obtenerEmail(String nombre, String apellido) {
        return nombre.substring(0, 1) + "." + apellido.substring(0, 3) + "@gmail.com";
    }

    public List<ResponseDto> obtenerEmpleados() {

        List<Empleado> empleados = empleadoRepository.findAll();
        List<ResponseDto> response = new ArrayList<>();
        for (Empleado empleado : empleados) {
            ResponseDto dto = new ResponseDto(
                    empleado.getFirstName(),
                    empleado.getLastName(),
                    obtenerEmail(empleado.getFirstName(), empleado.getLastName()),
                    obtenerNombreYApellidoAlReves(empleado.getFirstName(), empleado.getLastName())
            );
            response.add(dto);
        }
        return response;
//        for (Empleado empleado : empleados) {
//            ResponseDto dto = new ResponseDto();
//            dto.setNombre(empleado.getFirstName());
//            dto.setApellido(empleado.getLastName());
//            dto.setAlReves(obtenerNombreYApellidoAlReves(empleado.getFirstName(), empleado.getLastName()));
//            dto.setEmail(obtenerEmail(empleado.getFirstName(), empleado.getLastName()));
//            response.add(dto);
//        }

    }

}