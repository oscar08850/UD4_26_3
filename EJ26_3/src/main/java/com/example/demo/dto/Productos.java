package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "productos")
public class Productos {

	// Atributos de entidad cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "precio")
	private int precio;

	@OneToMany
	@JoinColumn(name = "producto")
	private List<Venta> venta;

	// Constructores

	public Productos() {
	}

	public Productos(int codigo, String nombre, int precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	// Getters y Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}


	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	public List<Venta> getVenta() {
		return venta;
	}

	
	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}


	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
}