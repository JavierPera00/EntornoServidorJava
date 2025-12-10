package com.EjercicioRepaso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "calorias")
	private Integer calorias;
	@ManyToMany(mappedBy = "ingredientes", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Receta> recetas = new ArrayList<>();;

	public Ingrediente() {
		super();
	}

	public Ingrediente(String nombre, Integer calorias) {
		super();
		this.nombre = nombre;
		this.calorias = calorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	@Override
	public String toString() {
		return "Ingrediente [ id = " + id + ", nombre = " + nombre + ", calorias = " + calorias + " ]";
	}

}
