<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<html>
<body>
<h2>Scriptles</h2>
<%
    Date fecha = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    out.println(sdf.format(fecha));
    out.println("<br/><strong>Cadena desde Java</strong>");
%>
</body>
</html>