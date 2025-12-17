package com.EjercicioRepaso10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EjercicioRepaso10.model.Empleado;
import com.EjercicioRepaso10.model.Oficina;
@Repository
public interface EmpleadoRepository  extends JpaRepository<Empleado, Integer>{

	public List<Empleado> findByPuesto(String puesto);
	
	public Integer countByIdOficina(Oficina idOficina);
}
