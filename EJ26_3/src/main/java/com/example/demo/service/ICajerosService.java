package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajeros;

public interface ICajerosService {

	// Metodos del CRUD
	public List<Cajeros> listarCajeros(); // Listar All

	public Cajeros guardarCajeros(Cajeros cajero); // Guarda un Usuario CREATE

	public Cajeros cajeroXID(int codigo); // Leer datos de un Usuario READ

	public Cajeros actualizarCajeros(Cajeros cajero); // Actualiza datos del Usuario UPDATE

	public void eliminarCajeros(int codigo);// Elimina el Usuario DELETE

}
