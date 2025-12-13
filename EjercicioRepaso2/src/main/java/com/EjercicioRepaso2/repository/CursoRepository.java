package com.EjercicioRepaso2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EjercicioRepaso2.model.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long>{

	//C
	public List<Curso> findByTitulo(String titulo);
	
	//E
	public List<Curso> findByTituloContainingIgnoreCase(String texto);
	
	//H
	public List<Curso> findByTituloStartingWith(String texto);
	
	//I
	public boolean existsByTitulo(String titulo);
}
