package com.EjercicioRepaso2.service;

import java.util.List;
import java.util.Optional;

import com.EjercicioRepaso2.model.Curso;

public interface CursoService{
	//CRUD
	public void saveCurso(Curso curso);	
	public List<Curso> getAllCursos ();
	public void deleteCurso(Long id);
	public Optional<Curso> findById(Long id);
	public Curso actualizar (Curso curso);
	//B
	public List<Curso> obtenerCursosDetalleInstructor();
	//C
	public List<Curso> findByTitulo(String titulo);
	//E
	public List<Curso> buscarTituloTexto (String texto);
	//I
	public boolean existsByTitulo(String titulo);
	// K
	public List<Curso> cursosDuracionInferior(Integer duracion);
}
