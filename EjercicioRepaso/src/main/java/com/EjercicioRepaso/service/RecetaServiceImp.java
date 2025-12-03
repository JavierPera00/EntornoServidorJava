package com.EjercicioRepaso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EjercicioRepaso.model.Ingrediente;
import com.EjercicioRepaso.model.Receta;
import com.EjercicioRepaso.repository.IngredienteRepository;
import com.EjercicioRepaso.repository.RecetaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecetaServiceImp implements RecetaService {

	@Autowired
	private RecetaRepository recetaRepository;

	@Override
	public Receta crearReceta(Receta r) {
		// TODO Auto-generated method stub
		return recetaRepository.save(r);
	}

	@Override
	public void eliminarReceta(Long id) {
		// TODO Auto-generated method stub
		recetaRepository.deleteById(id);
	}

	@Override
	public Receta buscarReceta(Long id) {
		// TODO Auto-generated method stub
		return this.recetaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Receta> listarRecetas() {
		// TODO Auto-generated method stub
		return this.recetaRepository.findAll();
	}

	@Override
	public Receta actualizarReceta(Receta r) {
		// TODO Auto-generated method stub
		return this.recetaRepository.save(r);
	}

	@Override
	public void asignarIngredientesAReceta(Long idReceta, List<Long> ingredienteId) {
		Receta receta = buscarReceta(idReceta);
		List<Ingrediente> ingredientes = new ArrayList<>();
		if(receta != null) {
			
		}
	}

	@Override
	public void elimanarIngredienteReceta(Long idReceta, Long idIngrediente) {
		Receta receta = buscarReceta(idReceta);
		
	}

	/*
	@Override
	public Receta recetaMayorPuntuacion() {
		List<Receta> recetas= recetaRepository.findAll();
		Integer puntuacion = null;
		Receta mayor = null;
		for (Receta receta : recetas) {
			if(puntuacion == null || receta.getPuntuacion() > puntuacion) {
				puntuacion = receta.getPuntuacion();
				mayor = receta;
			}
		}
		return mayor;
	}*/
	@Override
	public Receta recetaMayorPuntuacion() {
		
		return null;
	}

}
