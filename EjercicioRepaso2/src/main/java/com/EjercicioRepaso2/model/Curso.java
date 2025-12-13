package com.EjercicioRepaso2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="titulo")
	private String titulo;
	@Column(name="codigo)")
	private String codigo;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="id_detalle")
	private DetalleCurso detalle;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="id_instructor")
	private Instructor instructor;

	public Curso() {
		super();
	}
	
	public Curso(String titulo, String codigo, DetalleCurso detalle, Instructor instructor) {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
		this.detalle = detalle;
		this.instructor = instructor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public DetalleCurso getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleCurso detalle) {
		this.detalle = detalle;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", titulo=" + titulo + ", codigo=" + codigo + ", detalle=" + detalle
				+ ", instructor=" + instructor + "]";
	}
}
