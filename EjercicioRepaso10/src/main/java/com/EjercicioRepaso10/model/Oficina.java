package com.EjercicioRepaso10.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "oficina")
public class Oficina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "ubicacion")
	private String ubicacion;
	@Column(name = "telefono")
	private String telefono;
	
	public Oficina() {
		super();
	}
	
	public Oficina(String ubicacion, String telefono) {
		super();
		this.ubicacion = ubicacion;
		this.telefono = telefono;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Oficina [id=" + id + ", ubicacion=" + ubicacion + ", telefono=" + telefono + "]";
	}	
}
