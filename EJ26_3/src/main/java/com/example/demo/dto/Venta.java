package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venta") // en caso que la tabla sea diferente
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;

	@ManyToOne
	@JoinColumn(name = "producto")
	private Productos producto;
	@ManyToOne
	@JoinColumn(name = "cajero")
	private Cajeros cajero;
	@ManyToOne
	@JoinColumn(name = "maquina")
	private Maquinas maquina;

	// Constructores

	public Venta() {
	}

	public Venta(int id, Productos producto, Cajeros cajero, Maquinas maquina) {
		this.id = id;
		this.producto = producto;
		this.cajero = cajero;
		this.maquina = maquina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public Cajeros getCajero() {
		return cajero;
	}

	public void setCajero(Cajeros cajero) {
		this.cajero = cajero;
	}

	public Maquinas getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquinas maquina) {
		this.maquina = maquina;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", producto=" + producto + ", cajero=" + cajero + ", maquina=" + maquina + "]";
	}

}