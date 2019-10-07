package com.everis.jee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.bancos.Banco;
import com.everis.bancos.service.BancoService;

/**
 * Servlet implementation class BancosController
 */
public class BancosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static BancoService servicio = new BancoService();
	private int idBancoEntero;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BancosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Petici�n se hace directamente desde la URL aen el navegador 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idBanco = request.getParameter("idBancoeliminar");
		if (idBanco != null) {
			int idBancoEntero = Integer.parseInt(idBanco);		}
		servicio.eliminar(idBancoEntero);
		

		List<Banco> bancos = servicio.listar();{
		//controlador le envia datos a la vista 
			request.setAttribute("listaBancos", bancos);
			RequestDispatcher rd =request.getRequestDispatcher("adminBancos.jsp");
		
		
		//response.getWriter().append("<h1>Peticion Get </h1>");//.append(request.getContextPath());
		//String nombre = request.getParameter("nombre");
		//String direccion = request.getParameter("direccion");
		
		//response.getWriter().append("<br/>Nombre" + nombre.toUpperCase());
		//response.getWriter().append("<br/>Direccion" + direccion.toUpperCase());
	}
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
		String direccion = request.getParameter("direccion");
		
		BancoService servicio =  new BancoService();
		
		Banco banco = new Banco();
		banco.setNombre(nombre);
		banco.setDireccion(direccion);
		
		boolean exito = servicio.insertar(banco);
		if(exito == true) {
			response.getWriter().append("Banco insertado correctamente" + banco.getIdBanco());
			doGet(request, response);
		} else {
			response.getWriter().append("El nombre del banco ya existe");
		}
		
	}

}
