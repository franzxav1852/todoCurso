package com.everis.poo.dao;

import java.util.ArrayList;
import java.util.List;

import com.everis.poo.model.Banco;
import com.everis.poo.model.Cliente;

public class ClienteDAO {
	
	//lista para guardar solo clientes con libreria java.util
	private List<Cliente> clientes = new ArrayList<>();
	
	//metedodos
	public List<Cliente> listar() {
		return clientes;
	}
	
	public void insertar(Cliente cliente) {
		clientes.add(cliente);
		
	}
	
	public Cliente buscar(int idcliente) {
		for(Cliente cliente : clientes) {
			if(cliente.getIdCliente() == idcliente) {
				return cliente;
			}
		}
		return null;
	}

	
	public boolean actualizar(Cliente cliente) {
		Cliente encontrado = buscar(cliente.getIdCliente());
		if(encontrado != null) {
			encontrado.setNombre(cliente.getNombre());
			encontrado.setApaterno(cliente.getApaterno());
			encontrado.setAmaterno(cliente.getRfc());
			return true;
		}else {
			return false;
		}
	}
	
	public boolean eliminar(int IdCliente) {
		Cliente encontrado = buscar(IdCliente);
		if(encontrado != null) {
			clientes.remove(encontrado);
			return true;
		}else {
			return false;
		}
		
}
}
