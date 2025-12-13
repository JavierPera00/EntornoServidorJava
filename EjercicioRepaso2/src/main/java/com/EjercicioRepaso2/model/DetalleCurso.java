package com.EjercicioRepaso2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detalleCurso")
public class DetalleCurso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="duracionHoras")
	private Integer duracionHoras;
	@Column(name="nivel")
	private String nivel;
	@OneToOne(mappedBy="detalle",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Curso curso;
	
	
	public DetalleCurso() {
		super();
	}
	public DetalleCurso(Integer duracionHoras, String nivel, Curso curso) {
		super();
		this.duracionHoras = duracionHoras;
		this.nivel = nivel;
		this.curso = curso;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDuracionHoras() {
		return duracionHoras;
	}
	public void setDuracionHoras(Integer duracionHoras) {
		this.duracionHoras = duracionHoras;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@Override
	public String toString() {
		return "DetalleCurso [id=" + id + ", duracionHoras=" + duracionHoras + ", nivel=" + nivel + "]";
	}	
}
