package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="cajeros")
public class Cajeros {

	//Atributos de entidad cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "nomapels")
	private String nomapels;
	
    @OneToMany
    @JoinColumn(name="cajero")
    private List<Venta> venta;
	
	//Constructores
	
	public Cajeros() { 
	
	}

	public Cajeros(int codigo, String nomapels) {
		//super();
		this.codigo = codigo;
		this.nomapels = nomapels;
	}

	
	//Getters y Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cajero")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	//Metodo impresion de datos por consola
	
	@Override
	public String toString() {
		return "Cajeros [codigo=" + codigo + ", nomapels=" + nomapels + "]";
	}
}