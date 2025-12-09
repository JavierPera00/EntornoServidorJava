package com.EjercicioRepaso.service;

import java.util.List;

import com.EjercicioRepaso.model.Ingrediente;

public interface IngredienteService {

	// Crear Receta
	Ingrediente crearIngrediente(Ingrediente i);

	// Borrar Receta por ID
	void eliminarIngrediente(Long id);

	// Buscar Receta por ID
	Ingrediente buscarIngrediente(Long id);

	// Listar todas las recetas
	List<Ingrediente> listarIngrediente();

	// Actualizar Receta
	Ingrediente actualizarIngrediente(Ingrediente i);

	// Nuevos Metodos
	List<Ingrediente> listaIngredienteXCalorias(Integer calorias);

	// 7
	public List<Ingrediente> obtenerIngredientesConMasCalorias(int caloria);
}
