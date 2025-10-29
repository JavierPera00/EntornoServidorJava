package com.ejercicios.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Cliente;
import com.ejercicios.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
    private ClienteRepository clienteRepository;
	
	@Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getCliente(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente insertaCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente actualizarCliente(Cliente clienteActualizado) {
        Optional<Cliente> optCliente = clienteRepository.findById(clienteActualizado.getId());
        if (optCliente.isPresent()) {
            Cliente cliente = optCliente.get();
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setApellidos(clienteActualizado.getApellidos());
            return clienteRepository.save(cliente);
        }
        return null;
    }

   
    @Override
    public List<Cliente> getClientesNombre(String nombre) {
        return clienteRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    @Override
    public List<Cliente> getClienteNombreyApellidos(String nombre, String apellidos) {
        return clienteRepository.findByNombreAndApellidos(nombre, apellidos);
    }

    @Override
    public List<Cliente> getClientesOrdenadosApellidos() {
        return clienteRepository.findAllByOrderByApellidosAsc();
    }

    @Override
    public long getNumeroCliente(String nombre) {
        return clienteRepository.countByNombre(nombre);
    }
    
    
    @Override
    public List<Cliente> getClientesPrefijoSufijo(String prefijo, String sufijo) {

    	return clienteRepository.findByNombreStartingWithAndApellidosEndingWith(prefijo, sufijo);
    	// Si no usas el método derivado, sería:
    	//return clienteRepository.getClientesPrefijoSufijo(prefijo, sufijo);
       
    }
}
