package com.Ejercicio16.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "deportista")
public class Deportista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "deportista_deporte", joinColumns = {
			@JoinColumn(name = "id_deportista") }, inverseJoinColumns = { @JoinColumn(name = "id_deporte") })
	private Set<Deporte> deportes = new HashSet<>();

	public Deportista() {
		super();
	}

	public Deportista(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Deporte> getDeportes() {
		return deportes;
	}

	public void setDeportes(Set<Deporte> deportes) {
		this.deportes = deportes;
	}

	@Override
	public String toString() {
		return "deportista [id=" + id + ", nombre=" + nombre + "]";
	}
}
