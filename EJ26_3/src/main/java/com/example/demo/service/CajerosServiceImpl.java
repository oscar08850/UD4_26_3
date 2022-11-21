package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajerosDAO;
import com.example.demo.dto.Cajeros;

@Service
public class CajerosServiceImpl implements ICajerosService{
	
	@Autowired
	ICajerosDAO iCajerosDAO;

	@Override
	public List<Cajeros> listarCajeros() {
		
		return iCajerosDAO.findAll();
	}

	@Override
	public Cajeros guardarCajeros(Cajeros cajero) {
		
		return iCajerosDAO.save(cajero);
	}

	@Override
	public Cajeros cajeroXID(int codigo) {
		
		return iCajerosDAO.findById(codigo).get();
	}

	@Override
	public Cajeros actualizarCajeros(Cajeros cajero) {
		
		return iCajerosDAO.save(cajero);
	}

	@Override
	public void eliminarCajeros(int codigo) {
		
		iCajerosDAO.deleteById(codigo);
		
	}

}