package com.EjercicioRepaso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.EjercicioRepaso.service.RecetaService;
import com.EjercicioRepaso.service.MuestrarioService;
import com.EjercicioRepaso.model.Ingrediente;
import com.EjercicioRepaso.model.Muestrario;
import com.EjercicioRepaso.model.Receta;
import com.EjercicioRepaso.service.IngredienteService;

@SpringBootApplication
public class EjercicioRepasoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EjercicioRepasoApplication.class, args);
	}

	@Autowired
	RecetaService recetaService;
	@Autowired
	MuestrarioService MuestrarioService;
	@Autowired
	IngredienteService IngredienteService;

	// @Transactional // para el ejer 4 es necesario??

	public void run(String... args) throws Exception {

		System.out.println("APP");
		// 1
		Ingrediente i1 = new Ingrediente("Sal", 20);
		Ingrediente i2 = new Ingrediente("Azúcar", 300);
		IngredienteService.crearIngrediente(i1);
		IngredienteService.crearIngrediente(i2);

		Muestrario m1 = new Muestrario("Recetas Loli");
		Muestrario m2 = new Muestrario("Recetas Pepi");
		MuestrarioService.crearMuestrario(m1);
		MuestrarioService.crearMuestrario(m2);

		Receta r1 = new Receta("Papa con xoco", 10);
		Receta r2 = new Receta("Ensalailla", 8);
		recetaService.crearReceta(r1);
		recetaService.crearReceta(r2);
		// 2
		MuestrarioService.asignarRecetaMuestrario(r1, m2);
		MuestrarioService.asignarRecetaMuestrario(r2, m1);
		System.out.println(m2);
		// 3
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(i1);
		ingredientes.add(i2);
		recetaService.asignarIngredientesAReceta(ingredientes, r1);

		// 4
		mostrarRecetasIngredientesMuestrario(m1);

		// 5
		recetaService.elimanarIngredienteReceta(r1, i1);

		// 6
		m1.getRecetas().add(r1);

		// 7
		IngredienteService.obtenerIngredientesConMasCalorias(10).forEach(i -> System.out.print(i));

		// 8
		System.out.println(recetaService.recetaMayorPuntuacion());
		
		System.out.println("Fin");
	}

	// 4
	private void mostrarRecetasIngredientesMuestrario(Muestrario m1) {

		Optional<Muestrario> opt = MuestrarioService.findById(m1.getId());

		if (opt.isEmpty()) {
			System.out.println("No existe el muestrario con id: " + m1.getId());
			return;
		}

		Muestrario m = opt.get();

		System.out.println("=== Muestrario: " + m.getNombre() + " ===");

		for (Receta r : m.getRecetas()) {

			System.out.println("Receta: " + r.getNombre());

			if (r.getIngredientes().isEmpty()) {
				System.out.println("   (No tiene ingredientes)");
			} else {
				System.out.println("   Ingredientes:");
				for (Ingrediente ing : r.getIngredientes()) {
					System.out.println("     - " + ing.getNombre() + " (" + ing.getCalorias() + " cal)");
				}
			}

			System.out.println(); // línea separadora
		}
	}

}
