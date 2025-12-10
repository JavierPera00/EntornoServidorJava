package com.EjercicioRepaso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.EjercicioRepaso.model.Ingrediente;
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
	
	@GetMapping("/ingredientes/editar/{id}")
	public String editarIngrediente(@PathVariable Long id, Model model) {
		Ingrediente ingrediente = servicioIngrediente.buscarIngrediente(id);
		if (ingrediente == null) {
	        // redirigir o mostrar error
	        return "redirect:/ingredientes";
	    }
		model.addAttribute("ingrediente",ingrediente);
		return "editar";
	}
}
