package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductosDAO;
import com.example.demo.dto.Productos;


@Service
public class ProductosServiceImpl implements IProductosService{
	
	//Utilizamos los metodos de la interface IRolDAO, es como si instaciaramos.
	@Autowired
	IProductosDAO iProductosDAO;

	@Override
	public List<Productos> listarProductos() {
		
		return iProductosDAO.findAll();
	}

	@Override
	public Productos guardarProductos(Productos producto) {
		
		return iProductosDAO.save(producto);
	}

	@Override
	public Productos productosXID(int codigo) {
		
		return iProductosDAO.findById(codigo).get();
	}

	@Override
	public Productos actualizarProductos(Productos producto) {
		
		return iProductosDAO.save(producto);
	}

	@Override
	public void eliminarProductos(int codigo) {
		
		iProductosDAO.deleteById(codigo);
		
	}

}