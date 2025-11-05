package com.Ejercicio16.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.Ejercicio16.model.Deporte;
import com.Ejercicio16.model.Deportista;
import com.Ejercicio16.repository.DeportistaRepository;

public class DeportistaServiceImpl implements DeportistaService {

	@Autowired
	private DeportistaRepository deportistaRepo;

	@Override
	public Deportista crearDeportista(Deportista d) {
		return deportistaRepo.save(d);
	}

	@Override
	public void eliminar(Integer id) {
		deportistaRepo.deleteById(id);
	}

	@Override
	public Deportista actualizar(Deportista d) {
		return deportistaRepo.save(d);
	}

	@Override
	public Set<Deporte> agregarDeporteADeportista(Deportista deporti, Deporte deporte) {
		deporti.getDeportes().add(deporte);
		deportistaRepo.save(deporti);
		return deporti.getDeportes();
	}

	@Override
	public Deporte eliminarPorDeporteDeDeportista(Deportista deportista, Deporte deporte) {
		Deporte deporteEliminado = null;
		Iterator<Deporte> it = deportista.getDeportes().iterator();
		while (it.hasNext()) {
			if (it.next().getId().equals(deporte.getId())) {
				it.remove();
				deporteEliminado = it.next();
			}
		}
		deportistaRepo.save(deportista);
		return deporteEliminado;
	}

	@Override
	public List<Deportista> obtenerTodos() {
		return deportistaRepo.findAll();
	}

}
