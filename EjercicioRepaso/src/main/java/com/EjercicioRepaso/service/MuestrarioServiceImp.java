package com.EjercicioRepaso.service;

import java.util.List;

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
	public Muestrario actualizarMuestrario(Muestrario m) {
		// TODO Auto-generated method stub
		return this.muestrarioRepository.save(m);
	}

	@Override
	public void asignarRecetaMuestrario(Long recetaId, Long muestrarioId) {
		Muestrario muestra = muestrarioRepository.findById(muestrarioId).orElse(null);
		Receta receta = recetaRepository.findById(recetaId).orElse(null);
		if(muestra!=null && receta !=null) {
			muestra.getRecetas().add(receta);
			receta.setMuestrario(muestra);
			muestrarioRepository.save(muestra);
		}
	}

	@Override
	public void eliminarRecetaDeMuestrario(Long muestrarioId, Long recetaId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Receta> recetasMuestrarioEIngredientes(Long muestrarioId) {
		// TODO Auto-generated method stub
		return null;
	}

}
