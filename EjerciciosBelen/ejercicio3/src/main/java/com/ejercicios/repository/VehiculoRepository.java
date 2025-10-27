package com.ejercicios.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicios.modelo.Vehiculo;



@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    List<Vehiculo> findByEstado(String estado);

    List<Vehiculo> findByAnyoBetween(int anyoInicio, int anyoFin);
    
    Optional<Vehiculo> findTopByOrderByKilometrajeDesc();
}