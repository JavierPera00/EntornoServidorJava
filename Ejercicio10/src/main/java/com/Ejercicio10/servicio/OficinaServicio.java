package com.Ejercicio10.servicio;

import java.util.List;
import java.util.Map;

import com.Ejercicio10.modelo.Oficina;

public interface OficinaServicio {

	Oficina crear (Oficina oficina);
	List<Oficina> listar();
	Oficina buscarPorId(Integer id);
	void eliminar (Integer id);
	
	Integer contarEmpleados(Integer oficinaId);
	Map<Integer,Integer> mapaOficinasConCantidad();
	List<Oficina> oficinasConMasDeN(int n);
	void actualizarTelefonoPorEmpleadoId(Integer empleado);
}
