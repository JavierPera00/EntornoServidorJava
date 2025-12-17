package com.EjercicioRepaso10.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EjercicioRepaso10.model.Empleado;
import com.EjercicioRepaso10.repository.EmpleadoRepository;
import com.EjercicioRepaso10.repository.OficinaRepository;
import com.EjercicioRepaso10.services.EmpleadoService;



@Controller
public class TrabajoController {

	@Autowired
	EmpleadoRepository empleadoRepo;
	@Autowired
	EmpleadoService empleadoService;
	@Autowired
	OficinaRepository oficinaRepo;
	
	@GetMapping()
	public String mostrarInicio () {
		return "index";
	}
	
	// Crear Empleado
	@GetMapping("/crear")
	public String crearEmp (Model model) {
		model.addAttribute("crear", new Empleado());
		return "crearEmp";
	}
	
	@PostMapping("/crear")
	public String crearEmp (@RequestParam String nombre,@RequestParam String puesto,@RequestParam String email) {
		Empleado emp = new Empleado();
		emp.setNombre(nombre);
		emp.setPuesto(puesto);
		emp.setEmail(email);
		System.out.println(emp);
		empleadoRepo.save(emp);
		return "crearEmp";
	}
	
	@GetMapping("/consultarEmp")
	public String consultarEmp(Model model) {
		model.addAttribute("empleado", null);
		return "consultarEmp";
	}
	
	@PostMapping("/consultarEmp")
	public String consultarEmp(@RequestParam Integer idEmp,Model model) {
		Empleado emp = empleadoService.consultarPorId(idEmp);
		if(emp != null) {
			model.addAttribute("empleado",emp);
		}
		return "consultarEmp";
	}
	
	@GetMapping("/eliminarEmpleado")
    public String eliminarEmpleado() {
        return "eliminar";
    }
    @PostMapping("/eliminarEmpleado")
    public String eliminarEmpleado(@RequestParam Integer id, Model model) {
    	empleadoService.eliminarEmpleado(id);
        return "eliminar";
    }
    
    @GetMapping("/listarEmpleados")
    public String listarEmpleado() {
        return "listarEmp";
    }
    @PostMapping("/listarEmpleados")
    public String listarEmpleado(@RequestParam String puesto, Model model) {
    	List<Empleado> lista = empleadoService.listarEmpleadosPuesto(puesto);
    	model.addAttribute("lista",lista);
        return "listarEmp";
    }
    
    @GetMapping("/listarTodosEmpleados")
    public String listarTodosEmpleados(Model model) {
    	List<Empleado> lista = empleadoService.consultarEmpleado();
    	System.out.println(lista);
    	model.addAttribute("lista1",lista);
        return "listarTodosEmp";
    }
 
	
}
