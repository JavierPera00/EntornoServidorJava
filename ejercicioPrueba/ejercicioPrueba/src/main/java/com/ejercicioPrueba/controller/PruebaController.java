package com.ejercicioPrueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PruebaController {
	
	@GetMapping("/")
	public String mostrarInicio() {
		return "index";
	}
	
	@GetMapping("/home")
	public String mostrarHomre(Model model) {
		
		model.addAttribute("mensaje","Holaaaaa");
		model.addAttribute("nombre","<strong>Jara Jaramillo Becerril</strong>");
		model.addAttribute("rol","admin");
	
		String [] nombres = {"Juan","Jara","Javier","Jorge","Julia"};
		model.addAttribute("nombres",nombres);
		return "home";
		
	}
	
	@GetMapping("/form")
	public String mostrarFormulario() {
		return "form";
	}

}
