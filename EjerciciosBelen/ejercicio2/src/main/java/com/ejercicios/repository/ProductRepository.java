package com.ejercicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ejercicios.modelo.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    // 1. Productos cuyo nombre empiece por 'L' y precio < 5 (JPQL)
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT(:prefix, '%') AND p.price < :maxPrice")
    List<Product> findByNameStartingWithAndPriceLessThan(@Param("prefix") String prefix, @Param("maxPrice") Float maxPrice);

    List<Product> findByNameStartingWithAndPriceLessThan(String nombreInicio,Integer precioMax);
 
    // 2. Productos cuyo nombre contiene cadena ignorando mayúsculas (método derivado)
    List<Product> findByNameContainingIgnoreCase(String name);

    // 3. Productos por rango de precio
    List<Product> findByPriceBetween(Float minPrice, Float maxPrice);
}