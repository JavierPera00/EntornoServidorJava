package com.Ejercicio2.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ejercicio2.modelo.Producto;
import com.Ejercicio2.repository.ProductoRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> findByNameStartingWithAndPriceLessThan(String name,Float price) {
		return productoRepository.findByNameStartingWithAndPriceLessThan(name,price);
	}
	@Override
	public List<Producto> findByNameContainingIgnoreCase(String name) {
		return productoRepository.findByNameContainingIgnoreCase(name);
	}
	@Override
	public List<Producto> findByPriceBetween(Float minPrice,Float maxPrice) {
		return productoRepository.findByPriceBetween(minPrice,maxPrice);
	}
	@Override
	public List<Producto> saveAll(List<Producto> productos) {
		return productoRepository.saveAll(productos);
	}
}
