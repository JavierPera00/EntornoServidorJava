package com.Ejercicio6.servicio;

import java.util.List;

import com.Ejercicio6.modelo.Cliente;
import com.Ejercicio6.modelo.Direccion;

public interface ClienteServicio {

	List<Cliente> getAllClientes();
	
	Cliente getClienteById(Integer id);
	
	void saveCliente (Cliente cliente);
	
	Cliente updateCliente (Integer idCliente,Cliente cliente);
	
	Boolean deleteCliente(Integer id);
	
	Cliente actualizarDireccion (Integer id, Direccion direccion);

	void findByNombreStartingWithIgnoreCase(String letra);

	List<Cliente> findByCiudad(String ciudad);
		
	}

