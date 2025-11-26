package com.EJ06.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EJ06.modelo.Cliente;
import com.EJ06.servicio.ClienteServiceImp;
import com.EJ06.servicio.ClienteServicio;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/")
public class clienteController {

	@Autowired 
	ClienteServicio clienteServicio;
	
	
	@GetMapping
	public String mostrarClientes (Model model) {
		List<Cliente> cliente = clienteServicio.getAllClientes();
		model.addAttribute("clientes", cliente);
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver (@PathVariable Integer id,Model model) {
		model.addAttribute("cliente",clienteServicio.getClienteById(id));
		return "ver";
	}
	
	@GetMapping("/agregar")
	public String agregar (Model model) {
		model.addAttribute("cliente",new Cliente());
		return "añadir";
	}
	
	@PostMapping
	public String guardarCliente(Cliente cliente) {
	    clienteServicio.saveCliente(cliente); 
	    return "redirect:/";        // Redirige a la lista de clientes
	}
	
	 // FORMULARIO DE BUSQUEDA
    @GetMapping("/provincia")
    public String buscarProvinciaForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", null); // sin resultados al inicio
        return "provinciaBuscar";
    }

    @PostMapping("/provincia")
    public String buscarProvincia(Cliente cliente, Model model) {
        List<Cliente> resultados = clienteServicio.findByCiudad(cliente.getDireccion().getCiudad());
        model.addAttribute("clientes", resultados);
        model.addAttribute("cliente", cliente); // mantener valor en el formulario
        return "provinciaBuscar";
    }

	 

}
