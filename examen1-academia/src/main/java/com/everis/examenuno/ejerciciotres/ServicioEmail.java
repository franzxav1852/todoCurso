package com.everis.examenuno.ejerciciotres;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServicioEmail implements IServicioEmail{

	static boolean isValid(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	   }
	
	public void enviarCorreo(String email, String asunto, String texto) {
		// TODO Auto-generated method stub
		if(isValid(email)) {
			String remitente = "academiaeveris";
			
			Properties props = System.getProperties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.user", remitente);
		    props.put("mail.smtp.clave", "tecguru$");   
		    props.put("mail.smtp.auth", "true"); 
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.port", "587");
		    
		    Session session = Session.getDefaultInstance(props);
		    MimeMessage message = new MimeMessage(session);
		    
		    try {
		        message.setFrom(new InternetAddress(remitente));
		        message.addRecipients(Message.RecipientType.TO, email);   
		        message.setSubject(asunto);
		        message.setText(texto);
		        Transport transport = session.getTransport("smtp");
		        transport.connect("smtp.gmail.com", remitente, "tecguru$");
		        transport.sendMessage(message, message.getAllRecipients());
		        transport.close();
		    }
		    catch (MessagingException me) {
		        me.printStackTrace();
		    }
		}
		
		
	}

	public void enviarCorreoHTML(String email, String asunto, String html) {
		// TODO Auto-generated method stub 
		   if(isValid(email)) {
				String remitente = "academiaeveris";
				
				Properties props = System.getProperties();
			    props.put("mail.smtp.host", "smtp.gmail.com");
			    props.put("mail.smtp.user", remitente);
			    props.put("mail.smtp.clave", "tecguru$");   
			    props.put("mail.smtp.auth", "true"); 
			    props.put("mail.smtp.starttls.enable", "true");
			    props.put("mail.smtp.port", "587");
			    
			    Session session = Session.getDefaultInstance(props);
			    MimeMessage message = new MimeMessage(session);
			    
			    try {
			        message.setFrom(new InternetAddress(remitente));
			        message.addRecipients(Message.RecipientType.TO, email);  
			        message.setSubject(asunto);
			        message.setContent(html,"text/html");
			        Transport transport = session.getTransport("smtp");
			        transport.connect("smtp.gmail.com", remitente, "tecguru$");
			        transport.sendMessage(message, message.getAllRecipients());
			        transport.close();
			    }
			    catch (MessagingException me) {
			        me.printStackTrace();
			    }
			}
		
	}

}
