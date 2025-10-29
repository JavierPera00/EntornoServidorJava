package com.ejercicios.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private int anyo;

    @Column(unique = true)
    private String matricula;

    private String estado;
    private double kilometraje;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int anyo, String matricula, String estado, double kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
        this.matricula = matricula;
        this.estado = estado;
        this.kilometraje = kilometraje;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo +
                ", anyo=" + anyo + ", matricula=" + matricula + ", estado=" + estado +
                ", kilometraje=" + kilometraje + "]";
    }
}

