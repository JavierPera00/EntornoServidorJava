package com.EjercicioRepaso.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.EjercicioRepaso.model.Ingrediente;
import com.EjercicioRepaso.model.Receta;
import com.EjercicioRepaso.service.IngredienteService;
import com.EjercicioRepaso.service.RecetaService;

@Controller
public class RecetaController {

	@Autowired
	RecetaService servicioReceta;
	@Autowired
	IngredienteService servicioIngrediente;
	
	@GetMapping("/")
	public String mostrarInicio(Model model) {
		model.addAttribute("recetaMayor",servicioReceta.recetaMayorPuntuacion());
		return "index";
	}
	
	@GetMapping("/ingredientes")
	public String listadoIngrediente(Model model) {
		model.addAttribute("listado",servicioIngrediente.listarIngrediente());
		return "ingrediente";
	}
	
	@GetMapping("/ingredientes/nuevo")
	public String crearIngrediente(Model model) {
		model.addAttribute("ingrediente",new Ingrediente());
		return "crear";
	}
	
	@PostMapping("/ingredientes/nuevo")
	public String crearIngrediente(@RequestParam String nombre,@RequestParam Integer calorias) {
		Ingrediente i = new Ingrediente ();
		i.setCalorias(calorias);
		i.setNombre(nombre);
		System.out.println(i);
		servicioIngrediente.crearIngrediente(i);
		return "ingrediente";
	}
	
	@GetMapping("/ingredientes/editar/{id}")
	public String editarIngrediente(@PathVariable Long id, Model model) {
		Ingrediente i = servicioIngrediente.buscarIngrediente(id);
		if(i != null) {
			model.addAttribute("ingrediente",i);
		}
		return "editar";
	}
	
	@PostMapping("/ingredientes/editar/{id}")
	public String editarIngrediente(@PathVariable Long id,@RequestParam String nombre,@RequestParam Integer calorias) {
		Ingrediente i = servicioIngrediente.buscarIngrediente(id);
		if(i != null) {
			i.setNombre(nombre);
			i.setCalorias(calorias);
			servicioIngrediente.crearIngrediente(i);
		}
		return "redirect:/ingredientes";
	}
	
	
	@GetMapping("/consultas/mejor-receta")
	public String mostrarRecetaMayor(Model model) {
		//recetaMayorPuntuacion
		Receta r = servicioReceta.recetaMayorPuntuacion();
		if(r == null) {
		    model.addAttribute("boleano", true);
		} else {
		    model.addAttribute("boleano", false);
		    model.addAttribute("receta", r);
		}
		return "recetaMayor";
	}
	
}
