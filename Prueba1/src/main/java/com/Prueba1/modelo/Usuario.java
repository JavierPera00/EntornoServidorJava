package com.Prueba1.modelo;

public class Usuario {

	public String nombre;
	public Integer edad;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Usuario(String nombre, Integer edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public Usuario() {

	}
}
