package com.ejercicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejercicios.modelo.Cliente;
import com.ejercicios.repository.ClienteRepository;
import com.ejercicios.servicio.ClienteService;

@SpringBootApplication
public class Ejercicio1Application implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

	@Autowired
	ClienteService clienteService;

    Ejercicio1Application(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 System.out.println("==== Insertando clientes ====");
		 
		 	Cliente cl = new Cliente("Blanca","Santos");
		 	clienteService.insertaCliente(cl);
		 	System.out.println("id: " + cl.getId());
	        clienteService.insertaCliente(new Cliente("Pepe", "Martínez"));
	        clienteService.insertaCliente(new Cliente("Pepe", "González"));
	        clienteService.insertaCliente(new Cliente("Ana", "López"));
	        clienteService.insertaCliente(new Cliente("Pedro", "Sánchez"));
	        clienteService.insertaCliente(new Cliente("Pepa", "Ramírez"));

	        System.out.println("\n==== 1. getClientes ====");
	        clienteService.getClientes()
	                .forEach(c -> System.out.println(c.getId() + " - " + c.getNombre() + " " + c.getApellidos()));

	        System.out.println("\n==== 2. getCliente (por ID = 1) ====");
	        System.out.println(clienteService.getCliente(1));

	        System.out.println("\n==== 3. actualizarCliente (ID = 1) ====");
	        Cliente clienteActualizado = new Cliente("Pepe", "Martínez Actualizado");
	        clienteActualizado.setId(1); // 👈 IMPORTANTE: fijamos el ID que queremos actualizar
	        clienteService.actualizarCliente(clienteActualizado);
	        System.out.println(clienteService.getCliente(1));

	        System.out.println("\n==== 4. getClientesNombre (contiene 'pe', ignorando mayúsculas) ====");
	        clienteService.getClientesNombre("pe")
	                .forEach(c -> System.out.println(c.getNombre() + " " + c.getApellidos()));

	        System.out.println("\n==== 5. getClienteNombreyApellidos ('Pepe', 'González') ====");
	        clienteService.getClienteNombreyApellidos("Pepe", "González")
	                .forEach(c -> System.out.println(c.getNombre() + " " + c.getApellidos()));

	        System.out.println("\n==== 6. getClientesOrdenadosAPellidos ====");
	        clienteService.getClientesOrdenadosApellidos()
	                .forEach(c -> System.out.println(c.getNombre() + " " + c.getApellidos()));

	        System.out.println("\n==== 7. getNumeroCliente (nombre = 'Pepe') ====");
	        System.out.println("Número de clientes llamados Pepe: " + clienteService.getNumeroCliente("Pepe"));

	        System.out.println("\n==== 8. getClientesPrefijoSufijo ('Pe', 'ez') ====");
	        clienteService.getClientesPrefijoSufijo("Pe", "ez")
	                .forEach(c -> System.out.println(c.getNombre() + " " + c.getApellidos()));

	        System.out.println("\n==== 9. deleteCliente (ID = 2) ====");
	        clienteService.deleteCliente(2);
	        System.out.println("Clientes después de borrar el ID=2:");
	        clienteService.getClientes()
	                .forEach(c -> System.out.println(c.getId() + " - " + c.getNombre() + " " + c.getApellidos()));
	    }
	}
