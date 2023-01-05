package com.departamento.empleado.repository;

import com.departamento.empleado.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

//    @Query("select e from Empleado e where e.departamento = ?1")
//    List<Empleado> findByDepartamento(String deparment);

    List<Empleado> findByDeparment(String deparment);
}
