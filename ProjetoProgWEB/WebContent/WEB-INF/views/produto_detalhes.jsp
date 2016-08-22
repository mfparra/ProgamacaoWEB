<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalhes do produto</title>

<link rel="shortcut icon" href="/resources/css/images/favicon.ico" />

<spring:url value="/resources/css/detalhes.css" var="detalhesCSS" />
<spring:url value="/resources/js/jquery-1.7.min.js" var="js1" />
<spring:url value="/resources/js/jquery.jcarousel.js" var="js2" />
<spring:url value="/resources/js/DD_belatedPNG-min.js" var="js3" />
<spring:url value="/resources/js/functions.js" var="js4" />

<link href="${detalhesCSS}" rel="stylesheet" type="text/css" />
<script src="${js2}" type="text/javascript"></script>
<script src="${js3}" type="text/javascript"></script>
<script src="${js4}" type="text/javascript"></script>

</head>
<body>
	<jsp:useBean id="imagens" class="br.edu.ufabc.ecommerce.dao.ImagemDAO" />
	<input type="hidden" name="produtoSelecionado"
		value="${produtoSelecionado}" />
	<input type="hidden" name="listaImagens" value="${listaImagens}" />

	<div id="produto-detalhes" class="inline">
		<div class="images">
			<div class="main-image">
				<img src="${listaImagens[0].link}" width="240px">
			</div>
			<div class="tiny-images">
				<c:if test="${not empty listaImagens}">
					<c:forEach items="${listaImagens}" var="imagem">
						<img src="${imagem.link}" width="60px">
					</c:forEach>
				</c:if>
			</div>
		</div>

		<form action="${app}/Carrinho!adicionar.action" method="post">
			<input type="hidden" name="produtoId"
				value="${produtoSelecionado.id}" />

			<div>
				<h1 class="nome">${produtoSelecionado.modelo}
					(${produtoSelecionado.fabricante.nome})</h1>

				<div class="descricao">${produtoSelecionado.descricao}</div>

				<div class="preco">
					<fmt:setLocale value="pt_BR" />
					<fmt:formatNumber type="currency"
						value="${produtoSelecionado.valor}" />
				</div>


				<div class="quantidade">
					<input type="number" min="1" name="quantidade" value="1" />
				</div>

				<div class="comprar">
					<button type="submit">Adicionar ao Carrinho</button>
				</div>
			</div>
		</form>
	</div>
	<div id="produtos-relacionados"
		data-genero="${produtoSelecionado.categoria}">
		<h2>Você também pode gostar:</h2>
		<div class="content loading">
			<!-- Será carregado por AJAX -->
		</div>

	</div>
	<script src="${app}/js/prototype.js" type="text/javascript" />
	<script src="${app}/js/produtos_recomendados.js" type="text/javascript" />

</body>
</html>