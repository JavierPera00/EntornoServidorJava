package com.EjercicioRepaso10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.EjercicioRepaso10.modelo.Autor;
import com.EjercicioRepaso10.modelo.Libro;
import com.EjercicioRepaso10.service.AutorService;
import com.EjercicioRepaso10.service.LibroService;

@SpringBootApplication
public class EjercicioRepaso12Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EjercicioRepaso12Application.class, args);
	}
	@Autowired
	AutorService autorService;
	@Autowired
	LibroService libroService;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// Crear 5 autores
		Autor autor1 = new Autor();
		autor1.setNombre("RowLing");

		Autor autor2 = new Autor();
		autor2.setNombre("Pepin");

		Autor autor3 = new Autor();
		autor3.setNombre("Gabriel");

		Autor autor4 = new Autor();
		autor4.setNombre("Isabel");

		Autor autor5 = new Autor();
		autor5.setNombre("Carlos");

		// Guardar autores
		autorService.insertarAutor(autor1);
		autorService.insertarAutor(autor2);
		autorService.insertarAutor(autor3);
		autorService.insertarAutor(autor4);
		autorService.insertarAutor(autor5);

		// Crear 5 libros
		Libro libro1 = new Libro();
		libro1.setTitulo("Magia");

		Libro libro2 = new Libro();
		libro2.setTitulo("Gemelos");

		Libro libro3 = new Libro();
		libro3.setTitulo("Aventura");

		Libro libro4 = new Libro();
		libro4.setTitulo("Misterio");

		Libro libro5 = new Libro();
		libro5.setTitulo("Fantasía");

		// Guardar libros
		libroService.crearLibro(libro1);
		libroService.crearLibro(libro2);
		libroService.crearLibro(libro3);
		libroService.crearLibro(libro4);
		libroService.crearLibro(libro5);
		
		autor1.getLibrosAutor().add(libro1);

		autor1.getLibrosAutor().add(libro2);
		
		autor1.getLibrosAutor().add(libro3);
		
		autorService.actualizaAutor(autor1);
		
		System.out.println(libroService.listaLibros());
		
		System.out.println(autorService.listaAutores());
		
		System.out.println(autorService.obtenerDatosId(1));
		
		autor1.setNombre("Javielin");
		autorService.actualizaAutor(autor1);
		
		System.out.println(autorService.obtenerDatosId(autor1.getId()));
		
		System.out.println(libroService.listaAutorNombre("RowLing"));
		
		libro2.setTitulo("Nuevo Titulo");
		libroService.crearLibro(libro2);
		
		System.out.println(libroService.listaLibros());
		
		autorService.eliminarAutor(autor2.getId());
		
		System.out.println(autorService.listaAutores());
	}
}
