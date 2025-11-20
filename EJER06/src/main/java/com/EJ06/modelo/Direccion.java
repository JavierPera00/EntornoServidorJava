package com.EJ06.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "calle")
	private String calle;
	@Column(name = "ciudad")
	private String ciudad;
	
	public Direccion() {
	}
	public Direccion(String calle, String ciudad) {
		super();
		this.calle = calle;
		this.ciudad = ciudad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Direccion [ id = " + id + ", calle = " + calle + ", ciudad = " + ciudad + " ]";
	}	
}