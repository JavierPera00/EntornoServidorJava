package com.Ejercicio2.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ejercicio2.modelo.Vehiculo;
import com.Ejercicio2.repository.VehiculoRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class VehiculoServiceImpl implements VehiculoService{

	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Override
	public Vehiculo crearVehiculo(Integer id, String marca, String modelo, Integer anyo, String matricula,
			String estado, Double kilometraje) {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setAnyo(anyo);
		vehiculo.setEstado(estado);
		vehiculo.setId(id);
		vehiculo.setKilometraje(kilometraje);
		vehiculo.setMarca(marca);
		vehiculo.setMatricula(matricula);
		vehiculo.setModelo(modelo);
		return vehiculoRepository.save(vehiculo);
	}

	@Override
	public Vehiculo consultarVehiculo(Integer id) {
		return null;
	}

	@Override
	public List<Vehiculo> consultaListVehiculo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo actualizarVehiculo(Vehiculo vehiculo, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVehiculo(Integer id) {
		vehiculoRepository.deleteById(id);	
	}
	
	
}
