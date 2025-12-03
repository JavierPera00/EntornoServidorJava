package com.EjercicioRepaso.service;

import java.util.List;

import com.EjercicioRepaso.model.Muestrario;
import com.EjercicioRepaso.model.Receta;

public interface MuestrarioService {
	// Crear Receta
	Muestrario crearMuestrario(Muestrario r);

	// Borrar Receta por ID
	void eliminarMuestrario(Long id);

	// Buscar Receta por ID
	Muestrario buscarMuestrario(Long id);

	// Listar todas las recetas
	List<Muestrario> listarMuestrario();

	// Actualizar Receta
	Muestrario actualizarMuestrario(Muestrario r);
	
	// Nuevos Metodos
	void asignarRecetaMuestrario (Long recetaId, Long muestrarioId);
	
	void eliminarRecetaDeMuestrario(Long muestrarioId,Long recetaId);
	
	List<Receta> recetasMuestrarioEIngredientes(Long muestrarioId);
}
