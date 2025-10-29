package com.Ejercicio1.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ejercicio1.modelo.Cliente;
import com.Ejercicio1.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	@Override
	public Optional <Cliente> getCliente(Integer id){
		return clienteRepository.findById(id);
	}
	
	@Override
	public Cliente insertaCliente (Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Override
	public void deleteCliente (Integer id) {
		clienteRepository.deleteById(id);
	}
	
	@Override
	public Cliente actualizarCliente (Cliente clienteActualizado) {
	Optional<Cliente> optCliente = clienteRepository.findById(clienteActualizado.getId());
	if(optCliente.isPresent()) {
		Cliente c = optCliente.get();
		c.setNombre(clienteActualizado.getNombre());
		c.setApellidos(clienteActualizado.getApellidos());
		return clienteRepository.save(c);
	}
	return null;
	}
	
	@Override 
	public List<Cliente> getClientesNombre (String nombre){
	return clienteRepository.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	public List<Cliente> getClienteNombreApellido(String nombre, String apellidos) {
		return clienteRepository.findByNombreAndApellidos(nombre, apellidos);
	}
	
	@Override
	public List<Cliente> getClientesOrdenadosApellidos() {
		// TODO Auto-generated method stub
		return clienteRepository.findByOrderByApellidosAsc();
	}

	@Override
	public long getNumeroCliente(String nombre) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cliente> getClientesPrefijoSufijo(String cad1, String cad2) {
		// TODO Auto-generated method stub
		return null;
	}

}
