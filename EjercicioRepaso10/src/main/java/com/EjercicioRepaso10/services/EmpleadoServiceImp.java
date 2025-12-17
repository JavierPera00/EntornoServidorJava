package com.EjercicioRepaso10.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EjercicioRepaso10.model.Empleado;
import com.EjercicioRepaso10.repository.EmpleadoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpleadoServiceImp implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@Override
	public Empleado crearEmpleado(Empleado emp) {
		return empleadoRepo.save(emp);
	}

	@Override
	public List<Empleado> consultarEmpleado() {
		return empleadoRepo.findAll();
	}

	@Override
	public Empleado consultarPorId(Integer id) {
		return empleadoRepo.findById(id).orElse(null);
	}

	@Override
	public void eliminarEmpleado(Integer id) {
		this.empleadoRepo.deleteById(id);
	}

	@Override
	public List<Empleado> listarEmpleadosPuesto(String puesto) {
		return empleadoRepo.findByPuesto(puesto);
	}

	
}