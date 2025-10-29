package com.ejercicios.servicio;

import java.util.List;
import java.util.Optional;

import com.ejercicios.modelo.Vehiculo;

public interface VehiculoService {
    
	Vehiculo crearVehiculo(Vehiculo vehiculo);

    Optional<Vehiculo> getVehiculo(Long id);

    List<Vehiculo> getVehiculos();

    Vehiculo actualizarVehiculo(Long id, Vehiculo vehiculo);

    void eliminarVehiculo(Long id);

    Vehiculo actualizarEstado(Long id, String nuevoEstado);

    Vehiculo registrarKilometraje(Long id, double kms);

    List<Vehiculo> getVehiculosPorEstado(String estado);

    List<Vehiculo> filtrarVehiculosPorAnyo(int anyoInicio, int anyoFin);

    Optional<Vehiculo> masKms();
}
