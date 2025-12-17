package com.EjercicioRepaso10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EjercicioRepaso10.model.Oficina;
@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Integer>{


}
