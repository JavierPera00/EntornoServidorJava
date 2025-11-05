package com.Ejercicio16.service;


import java.util.List;
import java.util.Set;

import com.Ejercicio16.model.Deporte;
import com.Ejercicio16.model.Deportista;

public interface DeportistaService {

	// CRUD
	Deportista crearDeportista(Deportista d);

    void eliminar(Integer id);
    
	List<Deportista> obtenerTodos();
	
    Set<Deporte> agregarDeporteADeportista(Deportista deporti, Deporte deporte);
    
    Deportista actualizar(Deportista d);
    
    Deporte eliminarPorDeporteDeDeportista(Deportista deportista, Deporte deporte);
}
