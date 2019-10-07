package com.everis.jee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.bancos.Banco;
import com.everis.poo.model.Cliente;
import com.everis.poo.service.ClienteService;

/**
 * Servlet implementation class BancosController
 */
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static ClienteService servicio = new ClienteService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Petici�n se hace directamente desde la URL aen el navegador 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Cliente> clientes = servicio.listar();
		//controlador le envia datos a la vista 
		request.setAttribute("listaClientes",clientes);
		
		RequestDispatcher rd =request.getRequestDispatcher("adminClientes.jsp");
		

	}

	/**
	 * No se puede enviar directamende desde el navegador.
	 * Cliente http para hacer estas peticiones (Postman)
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);}
		String nombre = request.getParameter("nombre");
		String apaterno = request.getParameter("apaterno");
		String amaterno = request.getParameter("amaterno");
		String rfc = request.getParameter("rfc");
		int idCliente = Integer.parseInt("52");
						
		ClienteService servicio =  new ClienteService();
		
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setApaterno(apaterno);
		cliente.setAmaterno(amaterno);
		
		boolean exito = servicio.insertar(cliente);
		if(exito == true) {
			response.getWriter().append("Cliente insertado correctamente" + cliente.getIdCliente());
			doGet(request, response);
		} else {
			response.getWriter().append("El nombre del cliente ya existe");
		}
		
		
	}

}
