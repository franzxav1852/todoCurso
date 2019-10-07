package com.everis.actividadequipo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.everis.actividadequipo1.service.EmailService;

public class EmailController {
	
	@Autowired
	private EmailService correoService;
	
	@Autowired
	private Environment environment;
	
	
	if(configuracion.getTiponotificacion().equals("email")){
		Mensaje mensaje = new Mensaje();			
		mensaje.setNumero(configuracion.getWhatsappdestino());
		mensaje.setMensaje(nombreproducto);
		boolean correo2=correo.enviarCorreo(configuracion.getEmaildestino(), "Compra", mensaje.toString());
		if(correo2) {
			response.setSuccessful(true);
			response.setTipoMensaje("email");
			response.setMessage(mensaje.toString());
			response.setPedido(pedidoResponse.getPedido());
			response.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			return response;	
		}
		else {
			response.setSuccessful(false);
			response.setTipoMensaje("Imposible enviar email");
			return response;	
		}
	}

}
