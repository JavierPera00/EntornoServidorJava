package com.Ejercicio16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ejercicio16.model.Deporte;
import com.Ejercicio16.repository.DeporteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeporteServiceImpl implements DeporteService{

	@Autowired
	private DeporteRepository deporteRepo;

	@Override
	public Deporte crearDeporte(Deporte d) {
		return deporteRepo.save(d);
	}

	@Override
	public List<Deporte> obtenerTodos() {
		return deporteRepo.findAll();
	}

	@Override
	public Deporte obtenerPorId(Integer id) {
		return deporteRepo.findById(id).orElse(null);
	}

	@Override
	public Deporte actualizar(Deporte d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		deporteRepo.deleteById(id);
	}	
}
