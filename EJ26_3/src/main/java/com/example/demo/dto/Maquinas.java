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
@Table(name = "maquinas_registradoras")
public class Maquinas {

	// Atributos de entidad Maquinas
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "piso")
	private int piso;

	@OneToMany
	@JoinColumn(name = "maquina")
	private List<Venta> venta;

	// Constructores

	public Maquinas() {
	}

	public Maquinas(int codigo, int piso) {
		this.codigo = codigo;
		this.piso = piso;
	}

	// Getters y Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "maquina")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Maquinas [codigo=" + codigo + ", piso=" + piso + "]";
	}

}