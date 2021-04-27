<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.jmccursos.gerenciador.servlet.Empresa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	PrintWriter out = response.getWriter();
		
		<ul>
		<%
			List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");
			for (Empresa empresa : lista) {
		%>	
			<li><%= empresa.getNome() %></li>
		<%	
			}
		%>
		</ul>
		
</body>
</html>