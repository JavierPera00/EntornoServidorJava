package com.EjercicioRepaso10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EjercicioRepaso10.modelo.Autor;
import com.EjercicioRepaso10.service.AutorService;
import com.EjercicioRepaso10.service.LibroService;

@Controller
public class AutoresController {

	@Autowired
	AutorService autorService;
	@Autowired
	LibroService libroService;
	
	@GetMapping()
	public String mostrarIndex() {
		return "index";
	}
	
	@GetMapping("/listaAutor")
	public String listaAutor(Model model) {
		model.addAttribute("lista", autorService.listaAutores());
		return "listaAutor";
	}
	
	@GetMapping("/listaLibro")
	public String listaLibro(Model model) {
		model.addAttribute("lista", libroService.listaLibros());
		return "listaLibro";
	}
	
	@GetMapping ("/listaLibroAutorId")
	public String listaLibroAutorId () {
		return "listaLibroAutorId";
	}
	
	@PostMapping ("/listaLibroAutorId")
	public String listaLibroAutorId (@RequestParam Integer id,Model model) {
		model.addAttribute("lista", autorService.listaLibroAutorId(id));
		return "listaLibroAutorId";
	}
	
	@GetMapping ("/crearAutor")
	public String crearAutor (Model model) {
		model.addAttribute("autor", new Autor());
		return "crearAutor";
	}
	
	@PostMapping ("/crearAutor")
	public String crearAutor (@ModelAttribute Autor autor) {
		autorService.insertarAutor(autor);
		return "crearAutor";
	}
}
