package com.EjercicioRepaso.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "receta")
public class Receta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "puntuacion")
	private Integer puntuacion;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "receta_ingrediente", joinColumns = { @JoinColumn(name = "id_receta") }, inverseJoinColumns = {
			@JoinColumn(name = "id_ingrediente") })
	private List<Ingrediente> ingredientes = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "id_muestrario")
	private Muestrario muestrario;

	public Receta() {
	}

	public Receta(String nombre, Integer puntuacion) {
		super();
		this.nombre = nombre;
		this.puntuacion = puntuacion;
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

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Muestrario getMuestrario() {
		return muestrario;
	}

	public void setMuestrario(Muestrario muestrario) {
		this.muestrario = muestrario;
	}

	@Override
	public String toString() {
		return "Receta [id = " + id + ", nombre = " + nombre + ", puntuacion = " + puntuacion + " ]";
	}
}
