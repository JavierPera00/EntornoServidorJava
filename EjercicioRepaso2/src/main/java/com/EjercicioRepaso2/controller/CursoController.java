package com.EjercicioRepaso2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EjercicioRepaso2.model.Curso;
import com.EjercicioRepaso2.service.CursoService;
import com.EjercicioRepaso2.service.DetalleCursoService;
import com.EjercicioRepaso2.service.IntructorService;

@Controller
public class CursoController {

	@Autowired
	CursoService cursoService;
	@Autowired
	DetalleCursoService detalleCursoService;
	@Autowired
	IntructorService instructorService;
	
	
	@GetMapping("/")
	public String mostrarInicio() {
		return "index";
	}
	
	@GetMapping("/buscarPorTitulo")
	public String mostrarBuscarPorTitulo() {
		return "mostrarCursoTitulo";
	}
	
	@PostMapping("/buscarPorTitulo")
	public String mostrarCurso(@RequestParam String texto,Model model) {
		List<Curso> lista = cursoService.buscarTituloTexto(texto);
		lista.forEach(c->{
			System.out.println(c.getTitulo());
		});
		model.addAttribute("lista",lista);
		return "mostrarCursoTitulo";	
	}
	

	@GetMapping("/buscarPorInstructor")
	public String mostrarNombre() {
		return "mostrarInstructor";	
	}

	@PostMapping("/buscarPorInstructor")
	public String mostrarNombre(@RequestParam String nombre,Model model) {
		return "mostrarInstructor";	
	}
	
	
	@GetMapping("/buscarPorNivel")
	public String mostrarNivel() {
		return "mostrarNivel";
	}
	
	@PostMapping("/buscarPorNivel")
	public String mostrarNivel(@RequestParam String nivel,Model model) {
		model.addAttribute("lista1",detalleCursoService.findByNivel(nivel));
		return "mostrarNivel";
	}
	
	@GetMapping("/buscarPorDuracion")
	public String mostrarDuracion() {
		return "mostrarDuracion";
	}
	
	@PostMapping("/buscarPorDuracion")
	public String mostrarDuracion(@RequestParam Integer duracion,Model model) {
		model.addAttribute("lista1",cursoService.cursosDuracionInferior(duracion));
		return "mostrarDuracion";
	}
	
}
