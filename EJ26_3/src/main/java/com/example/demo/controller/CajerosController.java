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
import com.example.demo.dto.Cajeros;
import com.example.demo.service.CajerosServiceImpl;


@RestController
@RequestMapping("/api")

public class CajerosController {

	
	@Autowired
	CajerosServiceImpl CajerosServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajeros> listarCajeros(){
		return CajerosServiceImpl.listarCajeros();
	}
	
	@PostMapping("/cajeros")
	public Cajeros salvarCajeros(@RequestBody Cajeros cajero) {
		
		return CajerosServiceImpl.guardarCajeros(cajero);
	}
	
	@GetMapping("/cajeros/{codigo}")
	public Cajeros cajeroXID(@PathVariable(name="codigo") int codigo) {
		
		Cajeros cajero_xid= new Cajeros();
		
		cajero_xid=CajerosServiceImpl.cajeroXID(codigo);
		
		System.out.println("Cajero XID: "+cajero_xid);
		
		return cajero_xid;
	}
	
	@PutMapping("/cajeros/{codigo}")
	public Cajeros actualizarCajeros(@PathVariable(name="codigo")int codigo,@RequestBody Cajeros cajero) {
		
		Cajeros cajero_seleccionado= new Cajeros();
		Cajeros cajero_actualizado= new Cajeros();
		
		cajero_seleccionado= CajerosServiceImpl.cajeroXID(codigo);
		cajero_seleccionado.setNomapels(cajero.getNomapels());

		cajero_actualizado = CajerosServiceImpl.actualizarCajeros(cajero_seleccionado);
		
		System.out.println("El cajero actualizado es: "+ cajero_actualizado);
		
		return cajero_actualizado;
	}
	
	@DeleteMapping("/cajeros/{codigo}")
	public void eliminarCajeros(@PathVariable(name="codigo")int codigo) {
		CajerosServiceImpl.eliminarCajeros(codigo);
	}
	
	
}