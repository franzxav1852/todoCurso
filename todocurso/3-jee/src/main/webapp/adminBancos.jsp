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
      <form action="./BancosController" method = "POST">
          <input type="text" name="nombre" placeholder="Nombre del banco..."/>
          <br/>
          <textarea cols="50" name="direccion" placeholder="Direccion..."></textarea>
          <br>
          <input type="submit" value="Guardar" />
          <input type="reset" value="Limpiar" />
          
       </form>
       <%
           List<Banco> bancos = (List<Banco>) request.getAttribute("listaBanco");
       %>  
       <% if(bancos != null && bancos.size() > 0){%> 
       <table>
            <try>
                 
                 <td>Id Banco</td>
                 <td>Nombre</td>
                 <td>Direccion</td>
                 <td>Eliminar</td>
         
                </try>
                <% for(Banco banco : bancos) { %>
                <try> 
                     <td><%= banco.getIdBanco() %> <td>
                     <td><%= banco.getNombre()%> <td>
                     <td><%= banco.getDireccion() %> <td>
                     <td><a href="./BancosController?idBancoEliminar=<%=banco.getIdBanco() %>" %>Eliminar</a></td>
                <% } %>
       </table> 
       <% } %>
</body>
</html>


