package com.ejercicios.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Product;
import com.ejercicios.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findByNameStartingWithAndPriceLessThan(String prefix, Float maxPrice) {
        return productRepository.findByNameStartingWithAndPriceLessThan(prefix, maxPrice);
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> findByPriceBetween(Float minPrice, Float maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }
}