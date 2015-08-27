<%@page import="br.com.fabricadeprogramador.presistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
<script type="text/javascript">
function confirmaExclusao(id){
	if(window.confirm("Tem certeza que deseja exlcuir?")){
		location.href="usucontroller.do?acao=exc&id="+id;
	}
}
</script>
</head>
<body>
<%@include file="menu.jsp" %>
<%
	List<Usuario> list = (List<Usuario>) request.getAttribute("list");
%>
	<table border=1>
	<tr> <th> ID </th> <th> NOME </th> <th> LOGIN </th> <th> AÇÃO </th> </tr>
	<% for(Usuario u: list){ %>
		<tr>
		<td><%=u.getId()%></td> 
		<td><%=u.getNome()%></td> 
		<td><%=u.getLogin()%></td>
		<td><a href="javascript:confirmaExclusao(<%=u.getId()%>)">Excluir</a>|<a href="usucontroller.do?acao=alt&id=<%=u.getId()%>">Alterar</a></td>
		</tr>
	<%}%>
	</table>

</body>
</html>