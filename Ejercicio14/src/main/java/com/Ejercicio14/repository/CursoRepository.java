package com.Ejercicio14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ejercicio14.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findByNombreContainingIgnoreCase(String palabra);

}
