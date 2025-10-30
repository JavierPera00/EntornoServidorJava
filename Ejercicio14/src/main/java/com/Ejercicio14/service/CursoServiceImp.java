package com.Ejercicio14.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ejercicio14.model.Curso;
import com.Ejercicio14.model.Estudiante;
import com.Ejercicio14.repository.CursoRepository;
import com.Ejercicio14.repository.EstudianteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CursoServiceImp implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private EstudianteRepository estudianteRepository;

	// 1. Crear un curso con o sin estudiantes.
	@Override
	public void crearCurso() {
		Curso curso = new Curso();
		cursoRepository.save(curso);
	}

	// 2. Agregar un estudiante a un curso.
	@Override
	public Estudiante agregarEstudianteCurso(Integer idCurso, Estudiante estudiante) {
		Curso curso = consultarCurso(idCurso);
		if (curso != null) {
			curso.getEstudiantes().add(estudiante);
			estudiante.setCursoId(curso);
			return estudianteRepository.save(estudiante);
		}
		return estudiante;
	}

	// 3. Consultar todos los cursos.
	@Override
	public List<Curso> consultarCursos() {
		return cursoRepository.findAll();
	}

	// 4. Consultar un curso por su ID
	@Override
	public Curso consultarCurso(Integer id) {
		return cursoRepository.findById(id).orElse(null);
	}

	// 5. Buscar los cursos cuyo nombre contenga una palabra.
	public List<Curso> cursosNombrePalabra(String palabra) {
		return cursoRepository.findByNombreContainingIgnoreCase(palabra);
	}

	// 6. Eliminar un estudiante de un curso.
	@Override
	public void eliminar(Estudiante estudiante) {
	    List<Estudiante> lista = estudianteRepository.findAll(); // obtener todos
	    Iterator<Estudiante> iterator = lista.iterator();
	    while (iterator.hasNext()) {
	        Estudiante e = iterator.next();
	        if (e.getId().equals(estudiante.getId())) {
	            iterator.remove(); // elimina de la lista en memoria
	        }
	    }
	    estudianteRepository.delete(estudiante);
	    cursoRepository.delete(estudiante.getCursoId());
	}

	// 7. Eliminar un curso dado su ID.
	@Override
	public void eliminar(Integer id) {
		cursoRepository.deleteById(id);
	}

}
