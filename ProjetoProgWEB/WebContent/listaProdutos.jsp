<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/css/ecommerce.css" />" rel="stylesheet">
<title>Lista de Produtos</title>
</head>

<body>
	<jsp:include page="cabecalho.jsp" />
	<h2>Produtos</h2>
	<jsp:useBean id="bd" class="br.edu.ufabc.ecommerce.dao.ProdutoDAO" />

	<div id="lista-produtos">

		<c:forEach items="${bd.lista}" var="produto">
			<div class="produto">
				<div class="imagem">
					<img src="${app}/imagens?id=${produto.imagens[0].id}" />
				</div>
				<div class="descricao">${produto.descricao}</div>
				<div class="valor">
					<fmt:setLocale value="pt_BR" />
					<fmt:formatNumber type="currency" value="${produto.valor}" />
				</div>
			</div>
		</c:forEach>

		<p>
			<a id="inserir" href="insereProduto.jsp">Novo Produto</a><br />
		</p>

		<p>
			<a href="index.jsp">Voltar</a>
		</p>

	</div>
</body>
</html>