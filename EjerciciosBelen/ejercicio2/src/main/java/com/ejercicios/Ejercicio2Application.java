package com.ejercicios;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejercicios.modelo.Product;
import com.ejercicios.servicio.ProductService;

@SpringBootApplication
public class Ejercicio2Application implements CommandLineRunner  {

	@Autowired
	ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(Ejercicio2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		System.out.println("=== Insertando productos ===");
        List<Product> initialProducts = Arrays.asList(
                new Product("Leche", 1.5f),
                new Product("Limón", 0.9f),
                new Product("Lápiz", 0.5f),
                new Product("Libro", 4.8f),
                new Product("Chocolate", 2.0f),
                new Product("Café", 3.5f)
        );
        productService.saveAll(initialProducts);

        System.out.println("\n=== 1. Productos cuyo nombre empieza por 'L' y precio < 5 ===");
        productService.findByNameStartingWithAndPriceLessThan("L", 5f)
                .forEach(System.out::println);

        System.out.println("\n=== 2. Productos cuyo nombre contiene 'li' ignorando mayúsculas ===");
        productService.findByNameContainingIgnoreCase("li")
                .forEach(System.out::println);

        System.out.println("\n=== 3. Productos con precio entre 1 y 3.5 ===");
        productService.findByPriceBetween(1f, 3.5f)
                .forEach(System.out::println);

        System.out.println("\n=== 4. Insertar lista con mezcla de productos nuevos y existentes ===");
        List<Product> moreProducts = Arrays.asList(
                new Product(1, "Leche Entera", 1.6f),  // ID 1: actualizará
                new Product("Limón Verde", 1.0f),      // nuevo producto
                new Product("Chocolate Negro", 2.5f)   // nuevo producto
        );
        
        
        Product p1 = new Product("Galletas" , 2f);
        
        productService.saveAll(moreProducts);

        System.out.println("\n=== Todos los productos después de inserción/actualización ===");
        productService.findByPriceBetween(0f, 100f)
                .forEach(System.out::println);
		
	}

}
