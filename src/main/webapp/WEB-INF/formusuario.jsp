<!DOCTYPE html>
<%@page import="br.com.fabricadeprogramador.presistencia.entidade.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.jsp" %>
<%
Usuario u = (Usuario)request.getAttribute("usu");
 %>
	<form method="post" action="usucontroller.do" style="width: 742px; height: 179px; ">
		ID <input size="50" maxlength="32" name="id" value="<%=u.getId() %>"><br>Nome: <input size="75" maxlength="100" name="nome" value="<%=u.getNome() %>">
		<br>Login: <input size="50" maxlength="32" name="login" value="<%=u.getLogin()%>">
		<br>Senha: <input size="50" maxlength="32" name="senha" value="<%=u.getSenha() %>"><br><br><input size="25" name="botton" type="submit" value="Submit">
		
		
	</form>
</body>
</html>