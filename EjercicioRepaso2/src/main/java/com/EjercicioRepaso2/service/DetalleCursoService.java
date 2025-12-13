package com.EjercicioRepaso2.service;

import java.util.List;
import java.util.Optional;
import com.EjercicioRepaso2.model.DetalleCurso;

public interface DetalleCursoService {

	public void saveDetalleCurso(DetalleCurso detalleCurso);
	public List<DetalleCurso> getAllDetalleCurso ();
	public void deleteDetalleCurso(Long id);
	public Optional<DetalleCurso> findById(Long id);
	public DetalleCurso actualizar (DetalleCurso detalleCurso);
	
	//G
	public List<DetalleCurso> findByNivel (String nivel);
}
