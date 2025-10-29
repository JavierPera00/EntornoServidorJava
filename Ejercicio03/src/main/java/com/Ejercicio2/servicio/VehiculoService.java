package com.Ejercicio2.servicio;

import java.util.List;

import com.Ejercicio2.modelo.Vehiculo;

public interface VehiculoService {

	Vehiculo crearVehiculo(Integer id, String marca, String modelo, Integer anyo, String matricula, String estado, Double kilometraje);
	
	Vehiculo consultarVehiculo (Integer id);
	
	List<Vehiculo> consultaListVehiculo ();
	
	Vehiculo actualizarVehiculo (Vehiculo vehiculo, Integer id);
	
	void deleteVehiculo(Integer id);
}
