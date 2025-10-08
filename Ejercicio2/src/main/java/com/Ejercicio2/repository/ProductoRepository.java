package com.Ejercicio2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ejercicio2.modelo.Producto;



public interface ProductoRepository extends JpaRepository<Producto,Integer>{

	List<Producto> findByNameStartingWithAndPriceLessThan(String name, Float price);
	
	List<Producto> findByNameContainingIgnoreCase(String name);
	
	List<Producto> findByPriceBetween(Float minPrice, Float maxPrice);
}
