package com.EjercicioRepaso.repository;

import com.EjercicioRepaso.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {

	// 8
	public Receta findFirstByOrderByPuntuacionDesc();
}
