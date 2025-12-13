package com.EjercicioRepaso2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EjercicioRepaso2.model.Curso;
import com.EjercicioRepaso2.model.DetalleCurso;
import com.EjercicioRepaso2.repository.CursoRepository;
import com.EjercicioRepaso2.repository.DetalleCursoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CursoServiceImp implements CursoService{

	@Autowired
	CursoRepository cursoRepositorio;
	
	@Autowired
	DetalleCursoRepository detalleCursoRepositorio;
	
	public void saveCurso(Curso curso) {
		cursoRepositorio.save(curso);
	}
	
	public List<Curso> getAllCursos (){
		return cursoRepositorio.findAll();
	}
	
	public void deleteCurso(Long id) {
		cursoRepositorio.deleteById(id);
	}
	
	public Optional<Curso> findById(Long id){
		return cursoRepositorio.findById(id);
	}
	
	public Curso actualizar (Curso curso) {
		return cursoRepositorio.save(curso);
	}
	
	public List<Curso> obtenerCursosDetalleInstructor(){
		return cursoRepositorio.findAll();
	}
	
	public List<Curso> findByTitulo(String titulo){
		return cursoRepositorio.findByTitulo(titulo);
	}
	
	public List<Curso> buscarTituloTexto (String texto){
		return cursoRepositorio.findByTituloContainingIgnoreCase(texto);
	}
	
	public List<Curso> findByTituloStartingWith(String texto){
		return cursoRepositorio.findByTituloStartingWith(texto);
	}
	
	public boolean existsByTitulo(String titulo) {
		return cursoRepositorio.existsByTitulo(titulo);
	}
	public List<Curso> cursosDuracionInferior(Integer duracion){
		List<Curso> cursos = new ArrayList<>();;
		List<DetalleCurso> listaDC = detalleCursoRepositorio.findByDuracionHorasLessThan(duracion);
		for (DetalleCurso detalleCurso : listaDC) {
			cursos.add(detalleCurso.getCurso());
		}
		return cursos;
	}
}
