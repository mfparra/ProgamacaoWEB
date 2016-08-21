<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalhes do produto</title>
</head>
<body>
	<jsp:useBean id="imagens" class="br.edu.ufabc.ecommerce.dao.ImagemDAO" />

	<div id="produto-detalhes" class="inline">
		<div class="images">
			<div class="main-image">
				<img src="${app}/imagens?id=${produtoSelecionado.imagens[0].id}"
					onerror="this.src='${app}/img/jogo_padrao.png'" />
			</div>
			<div class="tiny-images">
				<c:if test="${not empty produtoSelecionado.imagens}">
					<c:forEach items="${produtoSelecionado.imagens}" var="imagem">
						<a href="${app}/imagens?id=${imagem.id}" target="_blank"> <img
							src="${app}/imagens?id=${imagem.id}" width="50px" />
						</a>
					</c:forEach>
				</c:if>
			</div>
		</div>

		<form action="${app}/Carrinho!adicionar.action" method="post">
			<input type="hidden" name="produtoId"
				value="${produtoSelecionado.id}" />

			<div>
				<h1 class="nome">${produtoSelecionado.nome}
					(${produtoSelecionado.desenvolvedora})</h1>

				<div class="descricao">${produtoSelecionado.descricao}</div>

				<div class="preco destaque">
					<fmt:setLocale value="pt_BR" />
					<fmt:formatNumber type="currency"
						value="${produtoSelecionado.precoComDesconto}" />
				</div>

				<div class="plataforma">
					<c:forEach items="${produtoSelecionado.plataformas}"
						var="plataforma">
						<label> <input required="required" type="radio"
							value="${plataforma.id}" name="plataformaId" /> ${plataforma}
						</label>
					</c:forEach>
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
		data-genero="${produtoSelecionado.genero}">
		<h2>Você também pode gostar:</h2>
		<div class="content loading">
			<!-- Será carregado por AJAX -->
		</div>

	</div>

	<script src="${app}/js/prototype.js" type="text/javascript" />
	<script src="${app}/js/produtos_recomendados.js" type="text/javascript" />


</body>
</html>