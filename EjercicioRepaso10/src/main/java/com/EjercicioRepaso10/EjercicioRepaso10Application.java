package com.EjercicioRepaso10;
import com.EjercicioRepaso10.services.OficinaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.EjercicioRepaso10.model.Empleado;
import com.EjercicioRepaso10.model.Oficina;
import com.EjercicioRepaso10.services.EmpleadoService;
import com.EjercicioRepaso10.services.OficinaService;

@SpringBootApplication
public class EjercicioRepaso10Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioRepaso10Application.class, args);
	}	
	@Autowired
	EmpleadoService empleadoService;
	@Autowired
	OficinaService oficinaService;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Oficina of1 = new Oficina("Madrid", "911111111");
		Oficina of2 = new Oficina("Barcelona", "922222222");
		Oficina of3 = new Oficina("Valencia", "933333333");
		oficinaService.crearOficina(of1);
		oficinaService.crearOficina(of2);
		oficinaService.crearOficina(of3);
		
		Empleado e1 = new Empleado("Juan Pérez", "Programador", "juan@empresa.com", of1);
		Empleado e2 = new Empleado("Ana López", "Analista", "ana@empresa.com", of1);
		empleadoService.crearEmpleado(e1);
		empleadoService.crearEmpleado(e2);
		Empleado e3 = new Empleado("Carlos Ruiz", "RRHH", "carlos@empresa.com", of2);
		Empleado e4 = new Empleado("Laura Gómez", "Marketing", "laura@empresa.com", of2);
		empleadoService.crearEmpleado(e3);
		empleadoService.crearEmpleado(e4);
		Empleado e5 = new Empleado("Miguel Torres", "Soporte", "miguel@empresa.com", of3);
		Empleado e6 = new Empleado("Sara Martín", "Ventas", "sara@empresa.com", of3);
		empleadoService.crearEmpleado(e5);
		empleadoService.crearEmpleado(e6);
		

		
		System.out.print(oficinaService.consultarOficinas());
		
		System.out.println(oficinaService.contarNumeroEmpleados(of3));
		
		System.out.println(oficinaService.consultarOficinaPorId(1));
		
		System.out.println(oficinaService.mapa(of3));
	}
	
	
}
