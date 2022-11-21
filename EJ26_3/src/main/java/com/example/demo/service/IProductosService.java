package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Productos;

public interface IProductosService {

	// Metodos del CRUD
	public List<Productos> listarProductos(); // Listar All

	public Productos guardarProductos(Productos producto); // Guarda un Rol CREATE

	public Productos productosXID(int codigo); // Leer datos de un Rol READ

	public Productos actualizarProductos(Productos producto); // Actualiza datos del Rol UPDATE

	public void eliminarProductos(int producto);// Elimina el Rol DELETE

}
