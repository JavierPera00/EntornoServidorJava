package com.EjercicioRepaso2.service;

import java.util.List;
import java.util.Optional;

import com.EjercicioRepaso2.model.Curso;
import com.EjercicioRepaso2.model.Instructor;

public interface IntructorService {

	public void saveInstructor(Instructor instructor);
	public List<Instructor> getAllInstructor ();
	public void deleteInstructor(Long id);
	public Optional<Instructor> findById(Long id);
	public Instructor actualizar (Instructor curso);
	
	//D
	public List<Curso> obtenerCursoPorNombreIns (String nombre);
}
