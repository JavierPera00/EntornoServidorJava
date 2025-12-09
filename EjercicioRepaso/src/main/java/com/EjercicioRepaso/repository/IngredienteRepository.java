package com.EjercicioRepaso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EjercicioRepaso.model.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

	// 7
	public List<Ingrediente> findByCaloriasGreaterThan(Integer caloria);
}