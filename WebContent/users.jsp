<%@page import="model.entidade.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Usuario>lista;
	lista = (ArrayList<Usuario>) session.getAttribute("lista");
	if(lista != null){
		out.println("<table>");
		for(int i = 0; i <lista.size(); i++){
			out.println("<tr>");
			out.println("<td>");
			out.println(lista.get(i).getId());
			out.println("</td>");
			out.println("<td>");
			out.println(lista.get(i).getNome());
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}
%>
</body>
</html>