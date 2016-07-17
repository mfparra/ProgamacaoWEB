<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Produtos</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp" />
	<h2>Produtos</h2>
	<jsp:useBean id="bd" class="br.edu.ufabc.ecommerce.dao.CategoriaDAO" />
	<div id="lista-categorias">
		<table>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
			</tr>

			<c:forEach items="${bd.lista}" var="categoria">
				<tr>
					<td>${categoria.nome}</td>
					<td>${categoria.descricao}</td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<a id="inserir" href="insereCategoria.jsp">Nova Categoria</a>
		</p>
		
		<p>
			<a href="index.jsp">Voltar</a>
		</p>
	</div>
</body>
</html>