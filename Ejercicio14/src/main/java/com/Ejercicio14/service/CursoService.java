package com.Ejercicio14.service;

import java.util.List;

import com.Ejercicio14.model.Curso;
import com.Ejercicio14.model.Estudiante;

public interface CursoService {

	//1
	void crearCurso();
	//2
	Estudiante agregarEstudianteCurso(Integer idCurso, Estudiante estudiante);
	//3
	List<Curso> consultarCursos();
	//4
	Curso consultarCurso (Integer id);
	//5
	List<Curso> cursosNombrePalabra(String palabra);
	//6
	void eliminar (Estudiante estudiante);
	//7
	void eliminar (Integer id);
	
}
