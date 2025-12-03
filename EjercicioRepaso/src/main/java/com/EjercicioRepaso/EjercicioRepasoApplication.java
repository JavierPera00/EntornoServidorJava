package com.EjercicioRepaso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.EjercicioRepaso.service.RecetaService;
import com.EjercicioRepaso.service.MuestrarioService;
import com.EjercicioRepaso.service.IngredienteService;
@SpringBootApplication
public class EjercicioRepasoApplication {

	@Autowired
	RecetaService recetaService;
	@Autowired
	MuestrarioService MuestrarioService;
	@Autowired
	IngredienteService IngredienteService;
	public static void main(String[] args) {
		SpringApplication.run(EjercicioRepasoApplication.class, args);
	}

}
