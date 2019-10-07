package com.everis.poo.service;

import java.util.ArrayList;
import java.util.List;

import com.everis.poo.dao.ClienteDAO;
import com.everis.poo.model.Cliente;

/**
 * Regla de negocio relacionados a clientes.
 * @author Dell5458
 *
 */

public class ClienteService {
	
	private ClienteDAO clienteDAO =  new ClienteDAO();
	
	public List<Cliente> listar(){
		return clienteDAO.listar();
	}
	public boolean insertar(Cliente cliente) {
		
		//En listamos los existentes en una nueva liscota
		List<Cliente> clientes = listar();
		
		for(Cliente objcliente : clientes) {
			if(objcliente.getRfc().equals(cliente.getRfc())){
				return false;
			}
		}
		clienteDAO.insertar(cliente);
		return true;
	
	}
	public Cliente buscar(int idcliente) {
		return clienteDAO.buscar(idcliente);
	}
	
	public boolean actualizar(Cliente cliente) {
		return clienteDAO.actualizar(cliente);
	}
	
	public boolean eliminar(int IdCliente) {
		return clienteDAO.eliminar(IdCliente);
	}
	

}
