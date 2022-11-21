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
import com.example.demo.dto.Maquinas;
import com.example.demo.service.MaquinasServiceImpl;


@RestController
@RequestMapping("/api")

public class MaquinasController {

	
	@Autowired
	MaquinasServiceImpl MaquinasServiceImpl;
	
	@GetMapping("/maquinas")
	public List<Maquinas> listarMaquinas(){
		return MaquinasServiceImpl.listarMaquinas();
	}
	
	@PostMapping("/maquinas")
	public Maquinas salvarMaquinas(@RequestBody Maquinas maquina) {
		
		return MaquinasServiceImpl.guardarMaquinas(maquina);
	}
	
	@GetMapping("/maquinas/{codigo}")
	public Maquinas maquinaXID(@PathVariable(name="codigo") int codigo) {
		
		Maquinas maquina_xid= new Maquinas();
		
		maquina_xid=MaquinasServiceImpl.maquinaXID(codigo);
		
		System.out.println("Maquinas XID: "+maquina_xid);
		
		return maquina_xid;
	}
	
	@PutMapping("/maquinas/{codigo}")
	public Maquinas actualizarMaquinas(@PathVariable(name="codigo")int codigo,@RequestBody Maquinas maquina) {
		
		Maquinas maquina_seleccionado= new Maquinas();
		Maquinas maquina_actualizado= new Maquinas();
		
		maquina_seleccionado= MaquinasServiceImpl.maquinaXID(codigo);
		maquina_seleccionado.setPiso(maquina.getPiso());

		maquina_actualizado = MaquinasServiceImpl.actualizarMaquinas(maquina_seleccionado);
		
		System.out.println("El maquina actualizado es: "+ maquina_actualizado);
		
		return maquina_actualizado;
	}
	
	@DeleteMapping("/maquinas/{codigo}")
	public void eliminarMaquinas(@PathVariable(name="codigo")int codigo) {
		MaquinasServiceImpl.eliminarMaquinas(codigo);
	}
	
	
}