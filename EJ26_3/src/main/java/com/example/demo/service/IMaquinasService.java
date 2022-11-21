package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Maquinas;

public interface IMaquinasService {

	// Metodos del CRUD
	public List<Maquinas> listarMaquinas(); // Listar All

	public Maquinas guardarMaquinas(Maquinas maquina); // Guarda un Usuario CREATE

	public Maquinas maquinaXID(int codigo); // Leer datos de un Usuario READ

	public Maquinas actualizarMaquinas(Maquinas maquina); // Actualiza datos del Usuario UPDATE

	public void eliminarMaquinas(int maquina);// Elimina el Usuario DELETE

}
