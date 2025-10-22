package com.Ejercicio10.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.Ejercicio10.modelo.Empleado;
import com.Ejercicio10.modelo.Oficina;
import com.Ejercicio10.repository.OficinaRepository;

public class OficinaServicioImp implements OficinaServicio {

	@Autowired
	private OficinaRepository oficinaRepository;

	@Override
	public Oficina crear(Oficina oficina) {
		return oficinaRepository.save(oficina);
	}

	@Override
	public List<Oficina> listar() {
		return oficinaRepository.findAll();
	}

	@Override
	public Oficina buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return oficinaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		oficinaRepository.deleteById(id);
	}

	@Override
	public Integer contarEmpleados(Integer oficinaId) {
		Oficina oficina = oficinaRepository.findById(oficinaId).orElse(null);
		if (oficina != null) {
			return oficina.getEmpleado().size();
		}
		return null;
	}

	@Override
	public Map<Integer, Integer> mapaOficinasConCantidad() {
		List<Oficina> oficinas = oficinaRepository.findAll();
		Map<Integer, Integer> resultado = new HashMap<>();
		for (Oficina oficina : oficinas) {
			Integer num = contarEmpleados(oficina.getId());
			resultado.put(oficina.getId(), num);
		}
		return resultado;
	}

	@Override
	public List<Oficina> oficinasConMasDeN(int n) {
		List<Oficina> lista1 = oficinaRepository.findAll();
		List<Oficina> lista2 = new ArrayList<>();
		for (Oficina oficina : lista1) {
			int num = contarEmpleados(oficina.getId());
			if (num > n) {
				lista2.add(oficina);
			}
		}
		return lista2;
	}

	@Override
	public void actualizarTelefonoPorEmpleadoId(Integer empleado) {
		List<Oficina> lista1 = oficinaRepository.findAll();
		Oficina oficina = null;
		for (Oficina of : lista1) {
			for (Empleado empleado1 : of.getEmpleado()) {
				if (empleado1.getId().equals(empleado)) {
					oficina = of;
				}
			}
		}

	}
}
