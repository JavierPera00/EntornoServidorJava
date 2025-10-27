package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Product;

public interface ProductService {

    List<Product> findByNameStartingWithAndPriceLessThan(String prefix, Float maxPrice);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByPriceBetween(Float minPrice, Float maxPrice);

    List<Product> saveAll(List<Product> products);
}
