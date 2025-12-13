package com.EjercicioRepaso2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EjercicioRepaso2.model.Curso;
import com.EjercicioRepaso2.model.Instructor;
import com.EjercicioRepaso2.repository.InstructorRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class IntructorServiceImp implements IntructorService {


	@Autowired
	InstructorRepository instructorRepository;
	
	public void saveInstructor(Instructor instructor) {
		instructorRepository.save(instructor);
	}
	
	public List<Instructor> getAllInstructor (){
		return instructorRepository.findAll();
	}
	
	public void deleteInstructor(Long id) {
		instructorRepository.deleteById(id);
	}
	
	public Optional<Instructor> findById(Long id){
		return instructorRepository.findById(id);
	}
	
	public Instructor actualizar (Instructor curso) {
		return instructorRepository.save(curso);
	}
	
	//D
	public List<Curso> obtenerCursoPorNombreIns (String nombre){
		Optional<Instructor> i = instructorRepository.findByNombre(nombre);
		if(i.isPresent()) {
			Instructor ins = i.get();
			return ins.getCursos();
		}
		return null;
	}
	//J
	public List<Instructor> findByNombreEndingWith(String texto){
		texto = "EZ";
		return instructorRepository.findByNombreEndingWith(texto);
	}
}
