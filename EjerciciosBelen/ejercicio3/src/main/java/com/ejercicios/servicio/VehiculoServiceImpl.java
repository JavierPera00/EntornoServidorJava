package com.ejercicios.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Vehiculo;
import com.ejercicios.repository.VehiculoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	VehiculoRepository vehiculoRepository;

	@Override
	public Vehiculo crearVehiculo(Vehiculo vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}

	@Override
	public Optional<Vehiculo> getVehiculo(Long id) {
		return vehiculoRepository.findById(id);
	}

	@Override
	public List<Vehiculo> getVehiculos() {
		return vehiculoRepository.findAll();
	}

	@Override
	public Vehiculo actualizarVehiculo(Long id, Vehiculo vehiculo) {
		
		Optional<Vehiculo> existente = vehiculoRepository.findById(id);
        if (existente.isPresent()) {
            Vehiculo v = existente.get();
            v.setMarca(vehiculo.getMarca());
            v.setModelo(vehiculo.getModelo());
            v.setAnyo(vehiculo.getAnyo());
            v.setMatricula(vehiculo.getMatricula());
            v.setEstado(vehiculo.getEstado());
            v.setKilometraje(vehiculo.getKilometraje());
            return vehiculoRepository.save(v);
        }
        return null; // O lanzar excepción si prefieres
		/*
		return vehiculoRepository.findById(id).map(v -> {
			v.setMarca(vehiculo.getMarca());
			v.setModelo(vehiculo.getModelo());
			v.setAnyo(vehiculo.getAnyo());
			v.setMatricula(vehiculo.getMatricula());
			v.setEstado(vehiculo.getEstado());
			v.setKilometraje(vehiculo.getKilometraje());
			return vehiculoRepository.save(v);
		}).orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
		*/
	}

	@Override
	public void eliminarVehiculo(Long id) {
		vehiculoRepository.deleteById(id);
	}

	@Override
	public Vehiculo actualizarEstado(Long id, String nuevoEstado) {
		
		Optional<Vehiculo> existente = vehiculoRepository.findById(id);
        if (existente.isPresent()) {
            Vehiculo v = existente.get();
            v.setEstado(nuevoEstado);
            return vehiculoRepository.save(v);
        }
        return null;
		/*
		return vehiculoRepository.findById(id).map(v -> {
			v.setEstado(nuevoEstado);
			return vehiculoRepository.save(v);
		}).orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
		*/
	}

	@Override
	public Vehiculo registrarKilometraje(Long id, double kms) {
		Optional<Vehiculo> existente = vehiculoRepository.findById(id);
        if (existente.isPresent()) {
            Vehiculo v = existente.get();
            v.setKilometraje(kms);
            return vehiculoRepository.save(v);
        }
        return null;
        /*
		return vehiculoRepository.findById(id).map(v -> {
			v.setKilometraje(kms);
			return vehiculoRepository.save(v);
		}).orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
		*/
	}

	@Override
	public List<Vehiculo> getVehiculosPorEstado(String estado) {
		return vehiculoRepository.findByEstado(estado);
	}

	@Override
	public List<Vehiculo> filtrarVehiculosPorAnyo(int anyoInicio, int anyoFin) {
		return vehiculoRepository.findByAnyoBetween(anyoInicio, anyoFin);
	}

	@Override
	public Optional<Vehiculo> masKms() {
		return vehiculoRepository.findTopByOrderByKilometrajeDesc();
	}
	
	
}
