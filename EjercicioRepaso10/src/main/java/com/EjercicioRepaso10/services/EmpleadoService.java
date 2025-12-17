package com.EjercicioRepaso10.services;

import java.util.List;

import com.EjercicioRepaso10.model.Empleado;

public interface EmpleadoService {

	Empleado crearEmpleado (Empleado emp);
	
	List<Empleado> consultarEmpleado();
	
	Empleado consultarPorId (Integer id);
	
	void eliminarEmpleado(Integer id);
	
	List<Empleado> listarEmpleadosPuesto (String puesto);
	
}
