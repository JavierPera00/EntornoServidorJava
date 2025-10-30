package com.Ejercicio14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ejercicio14.model.Estudiante;
import com.Ejercicio14.repository.EstudianteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	// 1 Consultar todos los estudiantes.
	@Override
	public List<Estudiante> consultarEstudiantes() {
		return estudianteRepository.findAll();
	}

	// 2 Consultar un estudiante por su ID.
	@Override
	public Estudiante consultarEstudiantes(Integer id) {
		return estudianteRepository.findById(id).orElse(null);
	}

	// 3 Actualizar el email de un estudiante dado su ID.
	@Override
	public void actualizaEmailEstudiante(Integer id) {
		Estudiante est = consultarEstudiantes(id);
		
	}

	// 4 Buscar estudiantes cuyo nombre contenga una cadena específica.
	@Override
	public Estudiante estudianteNombreContenga(String cadena) {
		return estudianteRepository.findByEmailContainingIgnoreCase(cadena);
	}

}
