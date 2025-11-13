package com.Prueba1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pruebaController {
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("mensaje", "Pim pam tomalacsito");
		
		return "index";
	}

}
