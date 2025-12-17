package com.EjercicioRepaso10.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EjercicioRepaso10.modelo.Autor;
import com.EjercicioRepaso10.modelo.Libro;
import com.EjercicioRepaso10.repository.AutorRepository;
import com.EjercicioRepaso10.repository.LibroRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AutorServiceImp implements AutorService{

	@Autowired
	private AutorRepository autorRepo;
	
	@Autowired
	private LibroRepository libroRepo;
	
	@Override
	public List<Autor> listaAutores() {
		return autorRepo.findAll();
	}

	@Override
	public Autor obtenerDatosId(Integer id) {
		return autorRepo.findById(id).orElse(null);
	}

	@Override
	public void insertarAutor(Autor autor) {
		Autor autor1 = autor;
		if(autor1 != null) {
			autorRepo.save(autor);
		}
	}

	@Override
	public void eliminarAutor(Integer id) {
		// TODO Auto-generated method stub
		autorRepo.deleteById(id);
	}

	@Override
	public void actualizaAutor(Autor autor) {
		Autor autorExistente = autorRepo.findById(autor.getId()).orElse(null);
        if (autorExistente != null) {
            autorExistente.setNombre(autor.getNombre());
            // Si quieres, puedes actualizar también la lista de libros:
            autorExistente.getLibrosAutor().clear();
            autorExistente.getLibrosAutor().addAll(autor.getLibrosAutor());
           autorRepo.save(autorExistente);
        }
        
    }

	@Override
	public void añadirLibroAutor(Libro libro,Autor autor) {
		// TODO Auto-generated method stub
		List<Libro> libros = autor.getLibrosAutor();
		libros.add(libro);
		autorRepo.save(autor);
	}

	@Override
	public void eliminarLibroAutor(Libro libro,Autor autor) {
		// TODO Auto-generated method stub
		List<Libro> libros = autor.getLibrosAutor();
		Iterator<Libro> iterator = libros.iterator();
		while (iterator.hasNext()) {
			Libro lib = iterator.next();
			if(lib.getTitulo().equalsIgnoreCase(libro.getTitulo())) {
				iterator.remove();
				break;
			}
		}
		autorRepo.save(autor);
	}

	@Override
	public List<Libro> listaLibroAutorId(Integer id) {
		List <Libro> listaLibro = new ArrayList<>();
		Autor autor = obtenerDatosId(id);
		if(autor != null) {
			listaLibro = autor.getLibrosAutor();
			autorRepo.save(autor);
			
		}
		return listaLibro;
	}
	
	@Override
	public void actualizaNombreAutor(String texto,String nombre) {
		 List<Autor> listaAutores = autorRepo.findAll();
	        Libro libroT = libroRepo.findByTitulo(nombre);
	        for(Autor autor : listaAutores) {
	            for(Libro libro : autor.getLibrosAutor()) {
	                if(libro.getTitulo().equals(libroT.getTitulo())) {
	                    autor.setNombre(nombre);
	                }
	            }
	            autorRepo.save(autor);
	        }
	}
}
