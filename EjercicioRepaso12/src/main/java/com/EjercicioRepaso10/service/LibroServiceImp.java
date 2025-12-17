package com.EjercicioRepaso10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EjercicioRepaso10.modelo.Autor;
import com.EjercicioRepaso10.modelo.Libro;
import com.EjercicioRepaso10.repository.AutorRepository;
import com.EjercicioRepaso10.repository.LibroRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LibroServiceImp implements LibroService{

	@Autowired
	private AutorRepository autorRepo;
	
	@Autowired
	private LibroRepository libroRepo;
	
	@Override
	public List<Libro> listaLibros() {
		return libroRepo.findAll();
	}

	@Override
	public List<Autor> listaAutorNombre(String texto) {
		return autorRepo.findByNombreContaining(texto);
	}


	@Override
	public void actualizaTituloId(Integer id,String titulo) {
		Libro libro = libroRepo.findById(id).orElse(null);
		if(libro != null) {
			libro.setTitulo(titulo);
			libroRepo.save(libro);
		}
	}

	@Override
	public void crearLibro(Libro libro) {
		// TODO Auto-generated method stub
		libroRepo.save(libro);
	}

}
