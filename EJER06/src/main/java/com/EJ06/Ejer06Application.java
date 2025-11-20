package com.EJ06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.EJ06.modelo.Cliente;
import com.EJ06.modelo.Direccion;
import com.EJ06.servicio.ClienteServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

 

 
@SpringBootApplication
public class Ejer06Application implements CommandLineRunner{
 
	public static void main(String[] args) {
		SpringApplication.run(Ejer06Application.class, args);
	}
	@Autowired
	ClienteServicio clienteService;
	@Override
	public void run(String... args) throws Exception {
		Direccion d1 = new Direccion("San fernando", "Pilas");
		Direccion d2 = new Direccion("Francia nº12", "Sevilla");
		Cliente c1 = new Cliente("Pepe",d1);
		Cliente c2 = new Cliente("Juan",d2);

		clienteService.saveCliente(c1);
		clienteService.saveCliente(c2);
	}
 
}
