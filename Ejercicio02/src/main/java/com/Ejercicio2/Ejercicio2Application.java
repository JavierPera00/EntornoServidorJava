package com.Ejercicio2;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.Ejercicio2.modelo.Producto;
import com.Ejercicio2.servicio.ProductoService;

@SpringBootApplication
public class Ejercicio2Application implements CommandLineRunner{
	@Autowired
	ProductoService  productoService;
	public static void main(String[] args) {
		SpringApplication.run(Ejercicio2Application.class, args);
	}
		@Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("===Productos===");
			List<Producto> initialProducts = Arrays.asList(
					new Producto ("Leche",2f),
					new Producto ("Libro",10f),
					new Producto ("Café",1f),
					new Producto ("Lápiz",1.2f)
					);
			
			System.out.println("\n===2 Insertar productos===");
			System.out.println(productoService.saveAll(initialProducts));
			
			System.out.println("\n===2 Productos cuyo nombre empieza por L y el precio sea mas bajo a 2===");
			System.out.println(productoService.findByNameStartingWithAndPriceLessThan("L", 4.0f));
			
			System.out.println("\n===3 Productos cuyo precio esten entre dos precios===");
			System.out.println(productoService.findByPriceBetween(1f, 3f));
			
			System.out.println("\n===4 Productos que contienen libro");
			System.out.println(productoService.findByNameContainingIgnoreCase("libro"));
			
		}
	}


