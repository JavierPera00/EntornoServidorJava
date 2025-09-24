package com.Ejercicio1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ejercicio1.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

	// 1. Obtener lista clientes cuyo nombre contenga la cadena
	List<Cliente> findByNombreContainingIgnoreCase(String nombre);
	
	
}
