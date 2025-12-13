package com.EjercicioRepaso2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EjercicioRepaso2.model.DetalleCurso;

public interface DetalleCursoRepository extends JpaRepository<DetalleCurso,Long>{

	//F
	public List<DetalleCurso> findByNivel(String nivel);
	
	public List<DetalleCurso> findByDuracionHorasLessThan(Integer duracion);
}
