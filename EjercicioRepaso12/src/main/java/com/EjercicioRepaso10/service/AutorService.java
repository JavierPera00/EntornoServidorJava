package com.EjercicioRepaso10.service;

import java.util.List;

import com.EjercicioRepaso10.modelo.Autor;
import com.EjercicioRepaso10.modelo.Libro;

public interface AutorService {

	List<Autor> listaAutores ();
	
	Autor obtenerDatosId (Integer id);
	
	void insertarAutor (Autor autor);
	
	void eliminarAutor(Integer id);
	
	void actualizaAutor(Autor autor);
	
	void añadirLibroAutor(Libro libro,Autor autor);
	
	void eliminarLibroAutor (Libro libro,Autor autor);
	
	List<Libro> listaLibroAutorId (Integer id);
	
	public void actualizaNombreAutor(String texto,String nombre);
	
}
