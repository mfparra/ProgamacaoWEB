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
	<jsp:useBean id="bd" class="br.edu.ufabc.ecommerce.dao.ProdutoDAO" />
	<div id="lista-produtos">
		<table>
			<tr>
				<th>Categoria</th>
				<th>Modelo</th>
				<th>Descrição</th>
				<th>Duração da Bateria</th>
				<th>Fabricante</th>
				<th>Tamanho da Tela</th>
				<th>Valor</th>
			</tr>

			<c:forEach items="${bd.lista}" var="produto">
				<tr>
					<td>${produto.categoria.nome}</td>
					<td>${produto.modelo}</td>
					<td>${produto.descricao}</td>
					<td>${produto.durBateria}</td>
					<td>${produto.fabricante.nome}</td>
					<td>${produto.tamTela}</td>
					<td>${produto.valor}</td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<a id="inserir" href="insereProduto.jsp">Novo Produto</a><br />
		</p>
		
		<p>
			<a href="index.jsp">Voltar</a>
		</p>
		
	</div>
</body>
</html>