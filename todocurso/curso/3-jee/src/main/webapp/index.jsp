<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<html>
<body>
<h2>Hello World!</h2>
<%
Date fecha = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
out.println(sdf.format(fecha));
out.println("<br/><strong> cadena desde java</strong>");
%> 





</body>
</html>
