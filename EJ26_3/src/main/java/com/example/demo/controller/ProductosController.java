package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Productos;
import com.example.demo.service.ProductosServiceImpl;


@RestController
@RequestMapping("/api")

public class ProductosController {

	
	@Autowired
	ProductosServiceImpl ProductosServiceImpl;
	
	@GetMapping("/productos")
	public List<Productos> listarProductos(){
		return ProductosServiceImpl.listarProductos();
	}
	
	@PostMapping("/productos")
	public Productos salvarProductos(@RequestBody Productos producto) {
		
		return ProductosServiceImpl.guardarProductos(producto);
	}
	
	@GetMapping("/productos/{codigo}")
	public Productos productoXID(@PathVariable(name="codigo") int codigo) {
		
		Productos producto_xid= new Productos();
		
		producto_xid=ProductosServiceImpl.productosXID(codigo);
		
		System.out.println("Producto XID: "+producto_xid);
		
		return producto_xid;
	}
	
	@PutMapping("/productos/{codigo}")
	public Productos actualizarProductos(@PathVariable(name="codigo")int codigo,@RequestBody Productos producto) {
		
		Productos producto_seleccionado= new Productos();
		Productos producto_actualizado= new Productos();
		
		producto_seleccionado= ProductosServiceImpl.productosXID(codigo);
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());

		producto_actualizado = ProductosServiceImpl.actualizarProductos(producto_seleccionado);
		
		System.out.println("El cientifico actualizado es: "+ producto_actualizado);
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/productos/{codigo}")
	public void eliminarProductos(@PathVariable(name="codigo")int codigo) {
		ProductosServiceImpl.eliminarProductos(codigo);
	}
	
	
}

