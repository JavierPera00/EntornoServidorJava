package com.Ejercicio6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Ejercicio6.modelo.Cliente;
import com.Ejercicio6.modelo.Direccion;
import com.Ejercicio6.servicio.ClienteServiceImp;

@SpringBootApplication
public class Ejercicio6Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ClienteServiceImp c = new ClienteServiceImp();
		
		c.saveCliente(new Cliente("Pepe Ruiz",new Direccion("calle Sol de Oviedo", null)));
		c.saveCliente(new Cliente("Andrés Ramírez",new Direccion("calle Mar de Cádiz", null)));
		System.out.println(c.getAllClientes());
	}
}
