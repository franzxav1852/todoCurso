<%@page import="com.everis.poo.model.Cliente"%>
<%@page import="com.everis.bancos.Banco"%>
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
      <form action="./ClientesController" method = "POST">
          <input type="text" name="nombre" placeholder="Nombre del cliente..."/>
          <input type="text" name="apaterno" placeholder="Apellido Paterno..."/>
          <input type="text" name="amaterno" placeholder="Apellido Materno..."/>
          <br/>
          <textarea cols="50" name="rfc" placeholder="RFC es..."></textarea>
          <br>
          <input type="submit" value="Guardar" />
          <input type="reset" value="Limpiar" />
          
       </form>
       <%
           List<Cliente> clientes = (List<Cliente>) request.getAttribute("listaCliente");
       %>  
       <% if(clientes != null && clientes.size() > 0){%> 
       <table>
            <try>
                 
                 <td>IdCliente</td>
                 <td>Nombre</td>
                 <td>Apaterno</td>
                 <td>Amaterno</td>
                 <td>Rfc</td>
                </try>
                <% for(Cliente cliente : clientes) { %>
                <try> 
                     <td><%= cliente.getIdCliente() %> <td>
                     <td><%= cliente.getNombre()%> <td>
                     <td><%= cliente.getApaterno() %> <td>
                     <td><%= cliente.getAmaterno() %> <td>
                     <td><%= cliente.getRfc() %> <td>
                     <td><a href="./ClientesController?idCliente<%=cliente.getIdCliente() %>" >Eliminar</a></td>
                <% } %>
       </table> 
       <% } %>
</body>
</html>


