package com.ejercicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejercicios.modelo.Vehiculo;
import com.ejercicios.servicio.VehiculoService;

@SpringBootApplication
public class Ejercicio3Application implements CommandLineRunner {

	@Autowired
	VehiculoService vehiculoService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Ejercicio3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		vehiculoService.crearVehiculo(new Vehiculo("Toyota", "Corolla", 2018, "1234ABC", "Disponible", 15000));
        vehiculoService.crearVehiculo(new Vehiculo("Ford", "Focus", 2020, "5678DEF", "En Mantenimiento", 48000));

        // Consultar todos
        System.out.println("\n=== Todos los vehículos ===");
        for (Vehiculo v : vehiculoService.getVehiculos()) {
            System.out.println(v);
        }

        // Consultar por estado
        System.out.println("\n=== Vehículos en mantenimiento ===");
        for (Vehiculo v : vehiculoService.getVehiculosPorEstado("En Mantenimiento")) {
            System.out.println(v);
        }

        // Vehículo con más kilómetros
        System.out.println("\n=== Vehículo con más kilómetros ===");
        vehiculoService.masKms().ifPresent(System.out::println);
	}

}
