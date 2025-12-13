package com.EjercicioRepaso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Autowired
	private IngredienteRepository ingredienteRepository;

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
	public void asignarIngredientesAReceta(List<Ingrediente> ingredientes, Receta receta) {
		for (Ingrediente ig : ingredientes) {

			Ingrediente i = ingredienteRepository.findById(ig.getId()).orElse(null);

			Receta r = recetaRepository.findById(receta.getId()).orElse(null);

			if (i != null && r != null) {
				r.getIngredientes().add(i);
				i.getRecetas().add(r);
				recetaRepository.save(r);
			}
		}
	}

	@Override
	public void elimanarIngredienteReceta(Receta receta, Ingrediente ingrediente) {
		Receta r = recetaRepository.findById(receta.getId()).orElse(null);
		Ingrediente i = ingredienteRepository.findById(ingrediente.getId()).orElse(null);

		if (r != null || i != null) {
			// Eliminar en ambos lados de la relación porque es bidireccional
			r.getIngredientes().remove(i);
			i.getRecetas().remove(r);

			// Guardar cambios

			ingredienteRepository.save(i);
			recetaRepository.save(r);
		}
	}

	/*
	 * @Override public Receta recetaMayorPuntuacion() { List<Receta> recetas=
	 * recetaRepository.findAll(); Integer puntuacion = null; Receta mayor = null;
	 * for (Receta receta : recetas) { if(puntuacion == null ||
	 * receta.getPuntuacion() > puntuacion) { puntuacion = receta.getPuntuacion();
	 * mayor = receta; } } return mayor; }
	 */
	@Override
	public Receta recetaMayorPuntuacion() {
		List<Receta> todas = recetaRepository.findAll();
		todas.forEach(r -> System.out.println(r.getNombre() + " -> " + r.getPuntuacion()));
		return recetaRepository.findFirstByOrderByPuntuacionDesc();
	}

	@Override
	public Optional<Receta> findById(Long id) {
		return Optional.empty();
	}
}
