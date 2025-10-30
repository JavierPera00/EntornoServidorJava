package com.Ejercicio14.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "email")
	private String email;
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso cursoId;

	public Estudiante() {
		super();
	}

	public Estudiante(Integer id, String email, Curso cursoId) {
		super();
		this.id = id;
		this.email = email;
		this.cursoId = cursoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Curso getCursoId() {
		return cursoId;
	}

	public void setCursoId(Curso cursoId) {
		this.cursoId = cursoId;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", email=" + email + ", cursoId=" + cursoId + "]";
	}
}
