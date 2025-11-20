package com.EJ06.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EJ06.modelo.Cliente;
import com.EJ06.servicio.ClienteServiceImp;
import com.EJ06.servicio.ClienteServicio;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/clientes")
public class clienteController {

	@Autowired 
	ClienteServicio clienteServicio;
	
	
	@GetMapping("/clientes")
	public String mostrarClientes (Model model) {
		List<Cliente> cliente = clienteServicio.getAllClientes();
		model.addAttribute("cliente", cliente);
		return "index";
	}
}
