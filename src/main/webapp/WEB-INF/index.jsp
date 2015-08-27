<!DOCTYPE html>
<%@page import="br.com.fabricadeprogramador.presistencia.entidade.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bem Vindo</title>
</head>
<body>
<%@include file="menu.jsp" %>
<h3>Bem Vindo <%= ((Usuario)request.getSession().getAttribute("usuAutenticado")).getNome()%>!!!</h3>
</body>
</html>