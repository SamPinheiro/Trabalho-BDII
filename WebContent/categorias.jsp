<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.entidade.Categoria"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>


<html lang="pt-br">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Início</title>
<link rel="stylesheet" href="css/style.min.css">
</head>

<body>
	<header>
		<div class="logo">
			<a href="index.html">CineHoje</a>
		</div>
		<ul class="navLinks">
			<li class="menu links"><a href="categorias.jsp">Categorias</a></li>
			<li class="cadastro links"><a href="cadastro.html">Cadastro</a></li>
		</ul>
		<div class="burguer">
			<div class="line1"></div>
			<div class="line2"></div>
			<div class="line3"></div>
		</div>
	</header>

	<section id="categorias">
		<%
			ArrayList<Categoria> lista = (ArrayList<Categoria>) session.getAttribute("lista"); 
			for (int i = 0; i < lista.size(); i++) {
		%>

		<a href="categoria.html">
			<div class="cardC">
				<h2>  <%=lista.get(i).getDescricao() %></h2>
			</div>
		</a>

		<%
			}
		%>
	</section>

	<footer>
		<p>Todos os direitos reservados.</p>
	</footer>

	<script src="js/nav.js"></script>
</body>

</html>