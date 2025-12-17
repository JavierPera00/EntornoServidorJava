package com.EjercicioRepaso10.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "puesto")
	private String puesto;
	@Column(name = "email")
	private String email;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idOficina")
	private Oficina idOficina;
	
	
	public Empleado() {
		super();

	}
	public Empleado(String nombre, String puesto, String email, Oficina idOficina) {
		super();
		this.nombre = nombre;
		this.puesto = puesto;
		this.email = email;
		this.idOficina = idOficina;
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
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Oficina getIdOficina() {
		return idOficina;
	}
	public void setIdOficina(Oficina idOficina) {
		this.idOficina = idOficina;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", puesto=" + puesto + ", email=" + email + ", idOficina="
				+ idOficina + "]";
	}
}
