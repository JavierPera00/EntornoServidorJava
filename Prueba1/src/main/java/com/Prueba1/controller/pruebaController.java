package com.Prueba1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Prueba1.modelo.Usuario;

@Controller
public class pruebaController {
	
	
	@GetMapping("/")
	public String mostrarInicio() {
		return "index";
	}
	
	@GetMapping("/home")
	public String mostrarHomre(Model model) {
		
		model.addAttribute("mensaje","Holaaaaa");
		model.addAttribute("nombre","<strong>Javier</strong>");
		model.addAttribute("rol","admin");
	
		String [] nombres = {"Juan","Jara","Javier","Jorge","Julia"};
		model.addAttribute("nombres",nombres);
		return "home";
		
	}
	
	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "form";
	}
	
	@PostMapping("/form")
	public String submitForm(@ModelAttribute Usuario user, Model model) {
		model.addAttribute("message","Formulario enviado con exito");
		model.addAttribute("usuario",user); //Envia de vuelta el usuario
		return "result";
	}

}
