package com.EjercicioRepaso2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EjercicioRepaso2.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor,Long>{

	//D
	public Optional<Instructor> findByNombre (String nombre);
	//J
	public List<Instructor> findByNombreEndingWith(String texto);
}
