package com.Ejercicio2.servicio;

import java.util.List;
import com.Ejercicio2.modelo.Producto;

public interface ProductoService {

	List<Producto> findByNameStartingWithAndPriceLessThan(String name,Float price);
		
	List<Producto> findByNameContainingIgnoreCase(String name);
		
	List<Producto> findByPriceBetween(Float minPrice,Float maxPrice); 
		
	List<Producto> saveAll(List<Producto> productos);

}
