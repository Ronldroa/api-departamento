package com.departamento.empleado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname", length = 20)
    String firstName;
    @Column(name = "lastname", length = 20)
    String lastName;
    @Column(name = "deparment", length = 20)
    String deparment;
    @Column(name = "salary", length = 8)
    int salary;
}
