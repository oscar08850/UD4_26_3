package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Venta;

public interface IVentaService {

	// Metodos del CRUD
	public List<Venta> listarVenta(); // Listar All

	public Venta guardarVenta(Venta venta);

	public Venta ventaXID(int id); // Leer datos de un Usuario READ

	public Venta actualizarVenta(Venta venta); // Actualiza datos del Usuario UPDATE

	public void eliminarVenta(int id);// Elimina el Usuario DELETE

}
