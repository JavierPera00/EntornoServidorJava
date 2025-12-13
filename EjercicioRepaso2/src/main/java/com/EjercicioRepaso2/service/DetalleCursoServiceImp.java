package com.EjercicioRepaso2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EjercicioRepaso2.model.DetalleCurso;
import com.EjercicioRepaso2.repository.DetalleCursoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetalleCursoServiceImp implements DetalleCursoService{

	@Autowired
	DetalleCursoRepository detalleCursoRepositorio;
	
	public void saveDetalleCurso(DetalleCurso detalleCurso) {
		detalleCursoRepositorio.save(detalleCurso);
	}
	
	public List<DetalleCurso> getAllDetalleCurso (){
		return detalleCursoRepositorio.findAll();
	}
	
	public void deleteDetalleCurso(Long id) {
		detalleCursoRepositorio.deleteById(id);
	}
	
	public Optional<DetalleCurso> findById(Long id){
		return detalleCursoRepositorio.findById(id);
	}
	
	public DetalleCurso actualizar (DetalleCurso curso) {
		return detalleCursoRepositorio.save(curso);
	}
	
	public List<DetalleCurso> findByNivel (String nivel){
		return detalleCursoRepositorio.findByNivel(nivel);
	}
}
