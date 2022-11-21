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
import com.example.demo.dto.Venta;
import com.example.demo.service.VentaServiceImpl;


@RestController
@RequestMapping("/api")

public class VentaController {

	
	@Autowired
	VentaServiceImpl VentaServiceImpl;
	
	@GetMapping("/ventas")
	public List<Venta> listarVenta(){
		return VentaServiceImpl.listarVenta();
	}
	
	@PostMapping("/ventas")
	public Venta salvarVenta(@RequestBody Venta venta) {
		
		return VentaServiceImpl.guardarVenta(venta);
	}
	
	@GetMapping("/ventas/{id}")
	public Venta ventaXID(@PathVariable(name="id") int id) {
		
		Venta venta_xid= new Venta();
		
		venta_xid=VentaServiceImpl.ventaXID(id);
		
		System.out.println("Venta XID: "+venta_xid);
		
		return venta_xid;
	}
	
	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name="id")int id,@RequestBody Venta venta) {
		
		Venta venta_seleccionado= new Venta();
		Venta venta_actualizado= new Venta();
		
		venta_seleccionado= VentaServiceImpl.ventaXID(id);
		venta_seleccionado.setProducto(venta.getProducto());
		venta_seleccionado.setCajero(venta.getCajero());
		venta_seleccionado.setMaquina(venta.getMaquina());

		venta_actualizado = VentaServiceImpl.actualizarVenta(venta_seleccionado);
		
		System.out.println("El usuario actualizado es: "+ venta_actualizado);
		
		return venta_actualizado;
	}
	
	@DeleteMapping("/ventas/{id}")
	public void eliminarVenta(@PathVariable(name="id")int id) {
		VentaServiceImpl.eliminarVenta(id);
	}
	
	
}