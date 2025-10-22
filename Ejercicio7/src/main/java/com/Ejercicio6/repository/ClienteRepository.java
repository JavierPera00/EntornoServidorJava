package com.Ejercicio6.repository;




import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Ejercicio6.modelo.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

	List<Cliente> findByNombreStartingWithIgnoreCase(String letra);

	List<Cliente> findByDireccionCiudad(String ciudad);
	
}
