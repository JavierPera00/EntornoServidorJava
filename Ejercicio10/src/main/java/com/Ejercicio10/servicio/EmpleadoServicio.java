package com.Ejercicio10.servicio;

import java.util.List;

import com.Ejercicio10.modelo.Empleado;

public interface EmpleadoServicio {

	// 1
	void crear(Empleado empleado);

	// 2
	List<Empleado> getAllEmpleados();

	// 3
	Empleado getEmpleados(Integer id);

	// 4
	Empleado actualizarEmpleado(Empleado empleado);

	// 5
	void deleteEmpleado(Integer id);

	// 6
	List<Empleado> listaEmpleadoPuesto(String puesto);
}
