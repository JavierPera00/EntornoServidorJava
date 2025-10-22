package com.Ejercicio10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ejercicio10.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

	List<Empleado> findByPuesto(String puesto);
}
