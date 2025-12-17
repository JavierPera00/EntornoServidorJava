package com.EjercicioRepaso10.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EjercicioRepaso10.modelo.Autor;
import com.EjercicioRepaso10.modelo.Libro;


@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{


	Libro findByTitulo(String titulo);
}
