package com.EjercicioRepaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EjercicioRepaso.model.Muestrario;


@Repository
public interface MuestrarioRepository extends JpaRepository<Muestrario, Long>{

}
