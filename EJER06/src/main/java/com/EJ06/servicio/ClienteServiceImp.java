package com.EJ06.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EJ06.modelo.Cliente;
import com.EJ06.modelo.Direccion;
import com.EJ06.repository.ClienteRepository;
import com.EJ06.repository.DireccionRepository;

@Service
public class ClienteServiceImp implements ClienteServicio{
	
	@Autowired
	private ClienteRepository clienteRepository;
	private DireccionRepository direccionRepository;

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getClienteById(Integer id) {
		return clienteRepository.findById(id).orElse(null);		
	}

	@Override
	public void saveCliente(Cliente cliente) {
	//Sin usar cascade
	Direccion direccion = cliente.getDireccion();
	if(direccion != null) {
		direccionRepository.save(direccion); //Sin usar cascade
	}
		clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(Integer idCliente, Cliente cliente) {
		Cliente optCliente = getClienteById(idCliente);
		if(optCliente == null) {
			return null;
		}
		optCliente.setNombre(cliente.getNombre());;
		Direccion nuevaDireccion = cliente.getDireccion();
			if(nuevaDireccion != null) {
				nuevaDireccion.setId(cliente.getDireccion().getId());
				direccionRepository.save(nuevaDireccion);
				cliente.setDireccion(nuevaDireccion);
			}
			return clienteRepository.save(optCliente);
	}

	@Override
	public Boolean deleteCliente(Integer id) {
		Cliente cliente = getClienteById(id);
		if(cliente != null) {
			clienteRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Cliente actualizarDireccion(Integer id, Direccion direccion) {
		Cliente optCliente = getClienteById(id);
		if(optCliente == null) {
			return null;
		}
		direccion.setId(optCliente.getDireccion().getId());
		direccionRepository.save(direccion);
		optCliente.setDireccion(direccion);
		return clienteRepository.save(optCliente);
	}

	@Override
	public void findByNombreStartingWithIgnoreCase(String letra) {	
		 List<Cliente> c = clienteRepository.findByNombreStartingWithIgnoreCase(letra);
		for (Cliente cliente : c) {
			Direccion d = cliente.getDireccion();
			d.setCiudad("Sevilla");
			direccionRepository.save(d);
		}
	}
	
	@Override
	public List<Cliente> findByCiudad(String ciudad){
		return clienteRepository.findByDireccionCiudad(ciudad);
	}
}