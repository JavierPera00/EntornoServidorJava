package com.Ejercicio1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Ejercicio1.modelo.Cliente;
import com.Ejercicio1.servicio.ClienteService;

@SpringBootApplication
public class Ejercicio1Application implements CommandLineRunner{

	@Autowired
	ClienteService servicio;
	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Insertando Clientes");
		servicio.insertaCliente(new Cliente("Javier","Pera"));
		servicio.insertaCliente(new Cliente("Juan","Garcia"));
		servicio.insertaCliente(new Cliente("Ignacio","Perez"));
		
		System.out.println("Get Clientes");
		System.out.println(servicio.getCliente(1));
		
		System.out.println("Borrar Clientes");
		servicio.deleteCliente(1);
		
		System.out.println("Actualizar Clientes");
		Cliente c = new Cliente("Juan","nacho");
		c.setId(2);
		servicio.actualizarCliente(c);
		
		System.out.println("getClientesNombre");
		List<Cliente> lista = servicio.getClientesNombre("J");
		for (Cliente cliente : lista) {
			System.out.println(cliente);
		}
		
		System.out.println("getClienteNombreyApellidos");
		List<Cliente> lista1 = servicio.getClienteNombreApellido("Juan", "nacho");
		for (Cliente cliente : lista1) {
			System.out.println(cliente);
		}
		
		System.out.println("getClientesOrdenadosApellidos");
		List<Cliente> lista2 = servicio.getClientesOrdenadosApellidos();
		for (Cliente cliente : lista2) {
			System.out.println(cliente);
		}
		
		System.out.println("getNumeroCliente");
	}

}
