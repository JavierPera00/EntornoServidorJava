package com.Ejercicio16.service;

import java.util.List;
import com.Ejercicio16.model.Deporte;


public interface DeporteService {

	// Crear un deporte
    Deporte crearDeporte(Deporte d);

    // Obtener todos los deportes
    List<Deporte> obtenerTodos();

    // Buscar un deporte por ID
    Deporte obtenerPorId(Integer id);

    // Actualizar un deporte existente
    Deporte actualizar(Deporte d);

    // Eliminar un deporte
    void eliminar(Integer id);
}
