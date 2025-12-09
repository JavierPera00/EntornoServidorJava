package com.EjercicioRepaso.service;

import java.util.List;
import java.util.Optional;

import com.EjercicioRepaso.model.Ingrediente;
import com.EjercicioRepaso.model.Receta;

public interface RecetaService {

	// Crear Receta
	Receta crearReceta(Receta r);

	// Borrar Receta por ID
	void eliminarReceta(Long id);

	// Buscar Receta por ID
	Receta buscarReceta(Long id);

	// Listar todas las recetas
	List<Receta> listarRecetas();

	// Actualizar Receta
	Receta actualizarReceta(Receta r);

	// Nuevos Metodos
	void asignarIngredientesAReceta(List<Ingrediente> ingredientes, Receta receta);

	void elimanarIngredienteReceta(Receta receta, Ingrediente ingrediente);
	
	Receta recetaMayorPuntuacion();
	
	Optional<Receta> findById(Long id);
}
