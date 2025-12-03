package com.EjercicioRepaso.service;

import java.util.List;
import com.EjercicioRepaso.model.Receta;
import com.EjercicioRepaso.repository.RecetaRepository;

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
	void asignarIngredientesAReceta(Long idReceta,List<Long> ingredienteId);

	void elimanarIngredienteReceta(Long idReceta,Long idIngrediente);
	
	Receta recetaMayorPuntuacion();
}
