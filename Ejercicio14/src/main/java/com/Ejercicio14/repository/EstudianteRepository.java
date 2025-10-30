package com.Ejercicio14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ejercicio14.model.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	Estudiante findByEmailContainingIgnoreCase(String cadena);

}
