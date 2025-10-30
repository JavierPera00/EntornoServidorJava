package com.Ejercicio14.service;

import java.util.List;

import com.Ejercicio14.model.Estudiante;

public interface EstudianteService {
	//1 Consultar todos los estudiantes.
	List<Estudiante> consultarEstudiantes();
	//2 Consultar un estudiante por su ID.
	Estudiante consultarEstudiantes(Integer id);
	//3 Actualizar el email de un estudiante dado su ID.
	void actualizaEmailEstudiante(Integer id);
	//4 Buscar estudiantes cuyo nombre contenga una cadena específica.
	Estudiante estudianteNombreContenga (String cadena);
}
