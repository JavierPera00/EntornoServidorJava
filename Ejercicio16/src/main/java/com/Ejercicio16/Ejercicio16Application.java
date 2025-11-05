package com.Ejercicio16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.Ejercicio16.model.Deportista;
import com.Ejercicio16.service.DeporteService;
import com.Ejercicio16.service.DeportistaService;

@SpringBootApplication
public class Ejercicio16Application {
	@Autowired
	private DeporteService deporteService;
	@Autowired
	private DeportistaService deportistaService;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio16Application.class, args);
	}

	public void run(String... args) throws Exception {

		Deportista deportista = new Deportista();
		deportista.setNombre("Javier");
		Deportista deportista1 = new Deportista();
		deportista1.setNombre("Juan");

		deportistaService.crearDeportista(deportista);
		deportistaService.crearDeportista(deportista1);
		
		System.out.println(deportistaService.obtenerTodos());
	}
}
