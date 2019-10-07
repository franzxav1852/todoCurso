package com.everis.jee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.poo.model.Banco;
import com.everis.poo.service.BancoService;

/**
 * Servlet implementation class BancosController
 */
public class BancosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static BancoService  service = new BancoService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BancosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Cuando la peticion se hace  directamente desde la URL en el navegador
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idBanco = request.getParameter("idBanco");
		if(idBanco !=null) {
			int idBancoEntero = Integer.parseInt(idBanco);
			service.eliminar(idBancoEntero);
		}
		
		List<Banco> bancos = service.listar();
		//Controlador manda datos a la vista
		request.setAttribute("Listabancos", bancos);
		//Interface que define un objeto que recibe peticiones y las reenvía a otro recurso
		RequestDispatcher rd = request.getRequestDispatcher("adminBancos.jsp");
		rd.forward(request, response);
	}

	/**
	 * No se puede neviar directamente desde el navegador,cliente http para hacer otras peticiones(Postman)
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		
		
		
		Banco banco = new Banco();
		banco.setNombre(nombre);
		banco.setDireccion(direccion);
		
		boolean exito = service.insertar(banco);
		if(exito == true) {
			response.getWriter().append("Banco insertado correctamente :" + banco.getIdBanco());
		}else {
			response.getWriter().append("El banco ya existe");
		}
		
	}

}
