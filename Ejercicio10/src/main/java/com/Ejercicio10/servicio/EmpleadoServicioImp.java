package com.Ejercicio10.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Ejercicio10.modelo.Empleado;
import com.Ejercicio10.repository.EmpleadoRepository;


public class EmpleadoServicioImp implements EmpleadoServicio{

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public void crear(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	public List<Empleado> getAllEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado getEmpleados(Integer id) {
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public void deleteEmpleado(Integer id) {
		empleadoRepository.deleteById(id);
	}

	@Override
	public List<Empleado> listaEmpleadoPuesto(String puesto) {
		// TODO Auto-generated method stub
		return empleadoRepository.findByPuesto(puesto);
	}
}
