package com.ejercicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	 // 1. Obtener lista de clientes cuyo nombre contenga la cadena (insensible a mayúsculas)
    List<Cliente> findByNombreContainingIgnoreCase(String nombre);

    // 2. Obtener lista de clientes con nombre y apellidos exactamente igual
    List<Cliente> findByNombreAndApellidos(String nombre, String apellidos);

    // 3. Obtener todos los clientes ordenados por apellidos ascendente
    List<Cliente> findAllByOrderByApellidosAsc();

    // 4. Contar cuántos clientes tienen exactamente ese nombre
    long countByNombre(String nombre); 
    
    //5. prefijo y sufijo
    List<Cliente> findByNombreStartingWithAndApellidosEndingWith(String prefijo, String sufijo);
   
    /*
     * @Query("SELECT c FROM Cliente c " +
       "WHERE c.nombre LIKE CONCAT(:prefijo, '%') " +
       "AND c.apellidos LIKE CONCAT('%', :sufijo)")
		List<Cliente> getClientesPrefijoSufijo(@Param("prefijo") String prefijo, @Param("sufijo") String sufijo);
     */
}