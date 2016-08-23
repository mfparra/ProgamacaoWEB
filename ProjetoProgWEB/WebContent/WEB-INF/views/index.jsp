<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Future Store - A melhor loja do Mundo</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="/resources/css/images/favicon.ico" />

<spring:url value="/resources/css/ecommerce.css" var="ecommerceCSS" />
<spring:url value="/resources/js/jquery-1.7.min.js" var="js1" />
<spring:url value="/resources/js/jquery.jcarousel.js" var="js2" />
<spring:url value="/resources/js/DD_belatedPNG-min.js" var="js3" />
<spring:url value="/resources/js/functions.js" var="js4" />

<link href="${ecommerceCSS}" rel="stylesheet" type="text/css" />
<script src="${js2}" type="text/javascript"></script>
<script src="${js3}" type="text/javascript"></script>
<script src="${js4}" type="text/javascript"></script>

</head>
<body>
	<div class="shell">
		<jsp:useBean id="produtos"
			class="br.edu.ufabc.ecommerce.dao.ProdutoDAO" />
		<jsp:useBean id="categorias"
			class="br.edu.ufabc.ecommerce.dao.CategoriaDAO" />
		<jsp:useBean id="fabricantes"
			class="br.edu.ufabc.ecommerce.dao.FabricanteDAO" />

		<input type="hidden" name="categoriaSelecionada"
			value="${categoriaSelecionada}" /> <input type="hidden" name="order"
			value="${order}" /> <input type="hidden" name="filtroProduto"
			value="${filtroProduto}" />

		<jsp:useBean id="imagens" class="br.edu.ufabc.ecommerce.dao.ImagemDAO" />
		<div id="top-navigation">
			<a title="My Account" href="#">Minha conta</a><a class="cart"
				title="Shopping Cart" href="#">Carrinho de compras</a><a
				class="checkout" title="Checkout" href="#">CHECKOUT</a><span>0
				items</span><span class="sep">|</span><span>$0,00</span>
		</div>
		<div class="welcome-message">
			<p>Seja bem-vindo!</p>
		</div>
		<div class="cl"></div>
		<div id="wrapper-top"></div>
		<!-- Wrapper Middle -->
		<div id="wrapper-middle">
			<!-- Header -->
			<div id="header">
				<!-- Search -->
				<div id="search">
					<form action="index" method="post">
						<input type="text" class="field" value="Procure por um produto..."
							title="Procure por um produto..." /> <input type="submit"
							value="" class="submit-button" />
					</form>
				</div>
				<!-- END Search -->
			</div>
			<!-- END Header -->
			<!-- Navigation -->
			<div id="navigation"
				style="background: url(/resources/css/images/navigation.png) no-repeat 0 0;">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/index?idCategoria=0">Todos</a></li>
					<c:forEach items="${categorias.lista}" var="categoria">
						<li><a
							href="${pageContext.request.contextPath}/index?idCategoria=${categoria.id}">${categoria.nome}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="cl"></div>
		</div>
		<!-- END Navigation -->
		<!-- Main -->
		<div id="main">

			<!-- Sidebar -->
			<div id="sidebar">
				<div class="box">
					<div class="title">
						<h2>Categorias</h2>
						<img class="bullet" src="css/images/bullet.png"
							alt="small grey bullet" />
					</div>
					<ul>
						<c:forEach items="${categorias.lista}" var="categoria">
							<li><a
								href="${pageContext.request.contextPath}/index?idCategoria=${categoria.id}">${categoria.nome}</a></li>
						</c:forEach>
					</ul>
				</div>

				<div class="box">
					<div class="title">
						<h2>Fabricantes</h2>
						<img class="bullet" src="css/images/bullet.png"
							alt="small grey bullet" />
					</div>
					<ul>
						<c:forEach items="${fabricantes.lista}" var="fabricante">
							<li>${fabricante.nome}</li>
						</c:forEach>
					</ul>
				</div>
			</div>

			<!-- END Sidebar -->
			<!-- Content -->
			<div id="content">
				<!-- Products -->
				<div class="produtos">
					<div class="title">
						<h2>Produtos</h2>
						<img class="bullet" src="css/images/bullet.png"
							alt="small grey bullet" />
						<p class="title-link" title="OrdenarPor">Ordernar por</p>
						<a class="title-link-nome" title="Nome"
							href="${pageContext.request.contextPath}/index?order=1">Nome</a>
						<a class="title-link-preco" title="Preço"
							href="${pageContext.request.contextPath}/index?order=2">Preço</a>
					</div>
					<div class="row">
						<c:choose>
							<c:when test="${!filtroProduto.equals('')}">
								<c:forEach
									items="${produtos.buscaProdutoPeloModelo(filtroProduto)}"
									var="produto">
									<a
										href="${pageContext.request.contextPath}/produtoDetalhes?id=${produto.id}">

										<div class="produto-holder">
											<div class="produto">
												<img src="${imagens.getLink(produto.id)}">
												<div class="descricao">
													<p>${produto.modelo}</p>
													<p class="preco">
														<fmt:setLocale value="pt_BR" />
														<fmt:formatNumber type="currency" value="${produto.valor}" />
													</p>
												</div>
												<div class="bottom"></div>
											</div>
										</div>
									</a>
									<div class="produto-bottom"></div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${categoriaSelecionada == 0}">
										<c:forEach items="${produtos.buscaProdutosOrdenados(order)}"
											var="produto">
											<a
												href="${pageContext.request.contextPath}/produtoDetalhes?id=${produto.id}">

												<div class="produto-holder">
													<div class="produto">
														<img src="${imagens.getLink(produto.id)}">
														<div class="descricao">
															<p>{produto.modelo}</p>
															<p class="preco">
																<fmt:setLocale value="pt_BR" />
																<fmt:formatNumber type="currency"
																	value="${produto.valor}" />
															</p>
														</div>
														<div class="bottom"></div>
													</div>
												</div>
											</a>
											<div class="produto-bottom"></div>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach
											items="${produtos.buscaListaPelaCategoria(categoriaSelecionada, order)}"
											var="produto">
											<a
												href="${pageContext.request.contextPath}/produtoDetalhes?id=${produto.id}">
												<div class="produto-holder">
													<div class="produto">
														<img src="${imagens.getLink(produto.id)}">
														<div class="descricao">
															<p>${produto.modelo}</p>
															<p class="preco">
																<fmt:setLocale value="pt_BR" />
																<fmt:formatNumber type="currency"
																	value="${produto.valor}" />
															</p>
														</div>
														<div class="bottom"></div>
													</div>
												</div>
											</a>
											<div class="produto-bottom"></div>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>

					</div>
					<div class="cl"></div>
				</div>

			</div>
			<!-- END Content -->
			<div class="cl"></div>
		</div>
		<!-- END Main -->
	</div>
	<!-- Footer  -->
	<div id="footer">
		<span class="author"> por Tulio Carreira e Marcos Parra</span>
	</div>
	<!-- END Footer -->
	</div>
</body>
</html>