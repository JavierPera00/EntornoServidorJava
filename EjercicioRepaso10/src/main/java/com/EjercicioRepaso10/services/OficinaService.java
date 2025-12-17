package com.EjercicioRepaso10.services;

import java.util.List;
import java.util.Map;

import com.EjercicioRepaso10.model.Empleado;
import com.EjercicioRepaso10.model.Oficina;

public interface OficinaService {

	Oficina crearOficina (Oficina oficina);
	
	List<Oficina> consultarOficinas ();
	
	Oficina consultarOficinaPorId(Integer id);
	
	void eliminarOficinaPorId(Integer id);
	
	Integer contarNumeroEmpleados (Oficina oficina);
	
	//Mapa
	Map<Integer,Integer> mapa (Oficina oficina);
	
	List<Oficina> listaEmpleado (Integer numero);
	
	void actualizarTelefono (String telefono, Integer id);
}
