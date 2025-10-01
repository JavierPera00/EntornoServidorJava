package com.Ejercicio1.servicio;

import java.util.List;
import java.util.Optional;



import com.Ejercicio1.modelo.Cliente;

public interface ClienteService{

	 List<Cliente> getClientes();
	 
	 Optional <Cliente> getCliente(Integer id);
	 
	 Cliente insertaCliente(Cliente cliente);
	 
	 void deleteCliente(Integer id);
	 
	 Cliente actualizarCliente (Cliente cliente);
	 
	 List<Cliente> getClientesNombre (String nombre);
	 
	 List<Cliente>getClienteNombreApellido(String nombre,String apellidos);
	 
	 List<Cliente> getClientesOrdenadosApellidos();
	 
	 long getNumeroCliente (String nombre);
	 
	 List<Cliente> getClientesPrefijoSufijo(String cad1,String cad2);
	
}
