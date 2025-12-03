package com.EjercicioRepaso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EjercicioRepaso.model.Ingrediente;
import com.EjercicioRepaso.repository.IngredienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IngredienteServiceImp implements IngredienteService {

	@Autowired
	private IngredienteRepository ingredienteRepository;

	@Override
	public Ingrediente crearIngrediente(Ingrediente i) {
		// TODO Auto-generated method stub
		return this.ingredienteRepository.save(i);
	}

	@Override
	public void eliminarIngrediente(Long id) {
		// TODO Auto-generated method stub
		this.ingredienteRepository.deleteById(id);
	}

	@Override
	public Ingrediente buscarIngrediente(Long id) {
		// TODO Auto-generated method stub
		return this.ingredienteRepository.findById(id).orElse(null);
	}

	@Override
	public List<Ingrediente> listarIngrediente() {
		// TODO Auto-generated method stub
		return this.ingredienteRepository.findAll();
	}

	@Override
	public Ingrediente actualizarIngrediente(Ingrediente i) {
		// TODO Auto-generated method stub
		return this.ingredienteRepository.save(i);
	}

	@Override
	public List<Ingrediente> listaIngredienteXCalorias(Integer calorias) {
		List<Ingrediente> todosIngredientes = ingredienteRepository.findAll();
		List<Ingrediente> ingredientesCalorias = new ArrayList<>();
		for (Ingrediente ingrediente : todosIngredientes) {
			if(ingrediente.getCalorias() >= calorias) {
				ingredientesCalorias.add(ingrediente);
			}
		}
		return ingredientesCalorias;
	}

}
