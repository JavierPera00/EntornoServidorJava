package com.EjercicioRepaso10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EjercicioRepaso10.modelo.Autor;

@Repository
public interface AutorRepository  extends JpaRepository<Autor, Integer>{

	public List<Autor> findByNombreContaining(String texto);
}
