package com.EjercicioRepaso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EjercicioRepaso.model.Muestrario;
import com.EjercicioRepaso.model.Receta;
import com.EjercicioRepaso.repository.MuestrarioRepository;
import com.EjercicioRepaso.repository.RecetaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MuestrarioServiceImp implements MuestrarioService {

	@Autowired
	private MuestrarioRepository muestrarioRepository;
	@Autowired
	private RecetaRepository recetaRepository;

	@Override
	public Muestrario crearMuestrario(Muestrario m) {
		// TODO Auto-generated method stub
		return muestrarioRepository.save(m);
	}

	@Override
	public void eliminarMuestrario(Long id) {
		// TODO Auto-generated method stub
		muestrarioRepository.deleteById(id);
	}

	@Override
	public Muestrario buscarMuestrario(Long id) {
		// TODO Auto-generated method stub
		return this.muestrarioRepository.findById(id).orElse(null);
	}

	@Override
	public List<Muestrario> listarMuestrario() {
		// TODO Auto-generated method stub
		return this.muestrarioRepository.findAll();
	}

	@Override
	public Optional<Muestrario> findById(Long id) {
		return Optional.empty();
	}

	@Override
	public Muestrario actualizarMuestrario(Muestrario m) {
		// TODO Auto-generated method stub
		return this.muestrarioRepository.save(m);
	}

	@Override
	public void asignarRecetaMuestrario(Receta receta, Muestrario muestrario) {
		Muestrario m = muestrarioRepository.findById(muestrario.getId()).orElse(null);

		Receta r = recetaRepository.findById(receta.getId()).orElse(null);

		if (m != null && r != null) {
			m.getRecetas().add(r);
			r.setMuestrario(m);

			recetaRepository.save(r);

			muestrarioRepository.save(m);
		}
	}

	@Override
	public void eliminarRecetaDeMuestrario(Receta receta, Muestrario muestrario) {
		Receta r = recetaRepository.findById(receta.getId()).orElse(null);
		Muestrario m = muestrarioRepository.findById(muestrario.getId()).orElse(null);

		if (r != null || m != null) {
			// 1. Quitar la receta de la lista del muestrario
			m.getRecetas().remove(r);

			// 2. Quitar la referencia al muestrario en la receta
			r.setMuestrario(null);

			// 3. Guardar cambios (opcional si usas @Transactional)
			muestrarioRepository.save(m);
		}

	}

	@Override
	public List<Receta> recetasMuestrarioEIngredientes(Long muestrarioId) {
		// TODO Auto-generated method stub
		return null;
	}

}
