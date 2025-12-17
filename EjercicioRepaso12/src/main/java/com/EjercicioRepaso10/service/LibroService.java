package com.EjercicioRepaso10.service;

import java.util.List;

import com.EjercicioRepaso10.modelo.Autor;
import com.EjercicioRepaso10.modelo.Libro;

public interface LibroService {

	List<Libro> listaLibros();
	
	List<Autor> listaAutorNombre(String texto);
	
	public void actualizaTituloId(Integer id,String titulo);
	
	void crearLibro(Libro libro);
}
