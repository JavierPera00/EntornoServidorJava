package com.EjercicioRepaso10.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EjercicioRepaso10.model.Empleado;
import com.EjercicioRepaso10.model.Oficina;
import com.EjercicioRepaso10.repository.EmpleadoRepository;
import com.EjercicioRepaso10.repository.OficinaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OficinaServiceImp implements OficinaService{

	@Autowired
	private OficinaRepository oficinaRepo;
	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@Override
	public Oficina crearOficina(Oficina oficina) {
		return oficinaRepo.save(oficina);
	}

	@Override
	public List<Oficina> consultarOficinas() {
		return oficinaRepo.findAll();
	}

	@Override
	public Oficina consultarOficinaPorId(Integer id) {
		return oficinaRepo.findById(id).orElse(null);
	}

	@Override
	public void eliminarOficinaPorId(Integer id) {
		this.oficinaRepo.deleteById(id);;
	}

	@Override
	public Integer contarNumeroEmpleados(Oficina oficina) {
		return empleadoRepo.countByIdOficina(oficina);
	}

	@Override
	public Map<Integer, Integer> mapa(Oficina oficina) {
		Map<Integer,Integer> mapaa = new HashMap<>();
		mapaa.put(oficina.getId(),empleadoRepo.countByIdOficina(oficina));
		if(mapaa.isEmpty()) {
			return null;
		}
		return mapaa;
	}

	@Override
	public List<Oficina> listaEmpleado(Integer numero) {
		List<Oficina> listaOficina = oficinaRepo.findAll();
		List<Oficina> listaVacia = new ArrayList<>();
		
		for (Oficina oficina : listaOficina) {
			Integer numero1 = contarNumeroEmpleados(oficina);
			if(numero1 > numero) {
				listaVacia.add(oficina);
			}
		}
		return listaVacia;
	}

	@Override
	public void actualizarTelefono(String telefono, Integer id) {
        Optional<Empleado> eO = empleadoRepo.findById(id);
        if(eO.isPresent()) {
            Empleado e = eO.get();
            e.getIdOficina().setTelefono(telefono);
        }
    }
}
