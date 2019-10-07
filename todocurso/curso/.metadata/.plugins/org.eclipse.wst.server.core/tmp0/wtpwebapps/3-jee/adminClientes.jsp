
<%@page import="com.everis.poo.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administración Clientes</title>


</head>
<body>

	<form action="./ClientesController" method="POST">
	<input type="text" name="idCliente" placeholder="ID del cliente...."/>
		<br/>
		<input type="text" name="nombre" placeholder="Nombre del cliente...."/>
		<br/>
		<input type="text" name="apaterno" placeholder="Apellido Paterno...."/>
		<br/>
		<input type="text" name= "amaterno" placeholder="Apellido Materno"/>
		<br>
		<input type="text" name="rfc" placeholder="Cliente RFC...."/>
		<br/>
		<input type="submit" value="Guardar"/>
		<input type="reset" value="Limpiar"/>
		
	</form>
	
	<%
	//recueperar lista del controlador
	  List<Cliente> clientes =  (List<Cliente>) request.getAttribute("Listaclientes");
	%>
	<%if(clientes != null && clientes.size() > 0){%>
	
	<table>
		<tr>
			<td>IdCliente</td>
			<td>Nombre</td>
			<td>ApellidoPaterno</td>
			<td>ApellidoPaterno</td>
			<td> RFC </td>
			<td> Eliminar </td>
			
		</tr>
		<%for(Cliente cliente : clientes) {%>
		  <tr>
		  	  <td><%=cliente.getIdCliente()%></td>
		  	  <td><%=cliente.getNombre() %></td>
		  	  <td><%=cliente.getApaterno() %></td>
		  	  <td><%=cliente.getAmaterno() %></td>
		  	  <td><%=cliente.getRfc() %></td>
		  	  <td><a href ="./ClientesController?idClienteEliminar=<%=cliente.getIdCliente() %>">Eliminar</a>
		  	  
		<% }%>
		
	</table><% }%>

</body>
</html>