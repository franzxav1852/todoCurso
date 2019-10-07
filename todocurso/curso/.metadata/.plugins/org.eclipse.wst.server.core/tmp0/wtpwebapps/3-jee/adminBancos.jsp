<%@page import="com.everis.poo.model.Banco"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./BancosController" method="POST">
		<input type="text" name="nombre" placeholder="Nombre del banco...."/>
		<br/>
		<textarea rows="5" cols="10" name="direccion" placeholder="Direccion.."></textarea>
		<br/>
		<input type="submit" value="Guardar"/>
		<input type="reset" value="Limpiar"/>
	</form>
	<%
	//recueperar lista del controlador
	  List<Banco> bancos =  (List<Banco>) request.getAttribute("Listabancos");
	%>
	<%if(bancos != null && bancos.size() > 0){%>
	
	<table>
		<tr>
			<td>Id Banco</td>
			<td>Nombre</td>
			<td>Dirección</td>
			
		</tr>
		<%for(Banco banco : bancos) {%>
		  <tr>
		  	  <td><%=banco.getIdBanco()%></td>
		  	  <td><%=banco.getNombre() %></td>
		  	  <td><%=banco.getDireccion() %></td>
		  	  <td><a href ="./BancosControlle?idBanco=<%=banco.getIdBanco() %>">Eliminar</a>
		  </tr>
		  	  
		<% }%>
		
	</table><% }%>
</body>
</html>