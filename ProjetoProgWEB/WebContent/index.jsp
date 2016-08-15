<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/ecommerce2.css" type="text/css"
	media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Produtos</title>
</head>

<body>
	<jsp:include page="cabecalho.jsp" />
	<h2>Produtos</h2>
	<jsp:useBean id="bd" class="br.edu.ufabc.ecommerce.dao.ProdutoDAO" />


	<div id="navigation">
		<ul>
			<li class="first"><a title="Home" href="#">Home<span
					class="home">&nbsp;</span></a></li>
			<li><a title="Cabinets" href="#">Cabinets</a></li>
			<li><a title="Sofa" href="#">Sofa</a></li>
			<li><a title="Armchair" href="#">Armchair</a></li>
			<li><a title="Tables" href="#">Tables</a></li>
			<li><a title="About Us" href="#">About Us</a></li>
			<li><a title="Contacts" href="#">Contacts</a></li>
		</ul>
	</div>
	<div id="content">
		<!-- Products -->
		<div class="products">
			<div class="title">
				<h2>Newest Products</h2>
				<a class="title-link" title="More Products" href="#">View More</a> <img
					class="bullet" src="css/images/bullet.png" alt="small grey bullet" />
			</div>
			<div class="row">
			<c:forEach items="${bd.lista}" var="produto">
				<div class="product-holder">
					<div class="product">
						<a title="More Details" href="#"><img src="css/images/1.jpg"
							alt="Yin Yang shaped bookshelf" /></a> <img class="top-label"
							src="css/images/top.png" alt="top sign" />
						
							<p><div class="descricao">${produto.descricao}</div></p>
							<p><div class="valor">
								<fmt:setLocale value="pt_BR" />
								<fmt:formatNumber type="currency" value="${produto.valor}" />
							</p>
						</div>
						<div class="bottom"></div>
					</div>
					<div class="product-bottom"></div>
				</div>
			</c:forEach>
				<div class="product-holder">
					<div class="product">
						<a title="More Details" href="#"><img src="css/images/2.jpg"
							alt="Television stand" /></a>
						<div class="desc">
							<p>Item Name</p>
							<p class="price">
								<span class="dollar">$</span>499,99&nbsp;&nbsp;<strike><span
									class="dollar">$</span>599,99</strike>
							</p>
						</div>
						<div class="bottom"></div>
					</div>
					<div class="product-bottom"></div>
				</div>
				<div class="product-holder">
					<div class="product">
						<a title="More Details" href="#"><img src="css/images/3.jpg"
							alt="Brown table with pink, blue and two green stools" /></a> <img
							class="top-label" src="css/images/top.png" alt="top sign" />
						<div class="desc">
							<p>
								Phasellus laoreet <br />lectus ac
							</p>
							<p class="price">
								<span class="dollar">$</span>699,99
							</p>
						</div>
						<div class="bottom"></div>
					</div>
					<div class="product-bottom"></div>
				</div>
			</div>
			<div class="row">
				<div class="product-holder">
					<div class="product">
						<a title="More Details" href="#"><img src="css/images/4.jpg"
							alt="table" /></a>
						<div class="desc">
							<p>Integer fermentum</p>
							<p class="price">
								<span class="dollar">$</span>399,99
							</p>
						</div>
						<div class="bottom"></div>
					</div>
					<div class="product-bottom"></div>
				</div>
				<div class="product-holder">
					<div class="product">
						<a title="More Details" href="#"><img src="css/images/5.jpg"
							alt="Armchair with a round stool" /></a> <img class="new-label"
							src="css/images/new.png" alt="new sign" />
						<div class="desc">
							<p>
								Phasellus lacus <br />lacus
							</p>
							<p class="price">
								<span class="dollar">$</span>439,99
							</p>
						</div>
						<div class="bottom"></div>
					</div>
					<div class="product-bottom"></div>
				</div>
				<div class="product-holder">
					<div class="product">
						<a title="More Details" href="#"><img src="css/images/6.jpg"
							alt="Brown sofa with two cushons" /></a>
						<div class="desc">
							<p>Gaming Computer</p>
							<p class="price">
								<span class="dollar">$</span>999,99&nbsp;&nbsp;<strike><span
									class="dollar">$</span>1 348,95</strike>
							</p>
						</div>
						<div class="bottom"></div>
					</div>
					<div class="product-bottom"></div>
				</div>
			</div>
			<div class="cl"></div>
		</div>
		<!-- END Products -->
		<!-- Products -->
		<div class="products best-sellers">
			<div class="title">
				<h2>Bestsellers</h2>
				<a class="title-link" title="More Bestsellers" href="#">More
					Bestsellers</a> <img class="bullet" src="css/images/bullet.png"
					alt="small grey bullet" />
			</div>
			<div class="row">
				<div class="product-holder">
					<div class="product">
						<a title="More Details" href="#"><img src="css/images/7.jpg"
							alt="Colourful armchairs" /></a>
						<div class="desc">
							<p>Item Name</p>
							<p class="price">
								<span class="dollar">$</span>678,99&nbsp;&nbsp;<strike><span
									class="dollar">$</span>750,00</strike>
							</p>
						</div>
						<div class="bottom"></div>
					</div>
					<div class="product-bottom"></div>
				</div>
				<div class="product-holder">
					<div class="product">
						<a title="More Details" href="#"><img src="css/images/8.jpg"
							alt="Black classical armchair" /></a> <img class="new-label"
							src="css/images/new.png" alt="new sign" />
						<div class="desc">
							<p>Item Name</p>
							<p class="price">
								<span class="dollar">$</span>399,99&nbsp;&nbsp;<strike><span
									class="dollar">$</span>450,00</strike>
							</p>
						</div>
						<div class="bottom"></div>
					</div>
					<div class="product-bottom"></div>
				</div>
				<div class="product-holder">
					<div class="product">
						<a title="More Details" href="#"><img src="css/images/9.jpg"
							alt="White sofa" /></a>
						<div class="desc">
							<p>Item Name</p>
							<p class="price">
								<span class="dollar">$</span>799,99&nbsp;&nbsp;<strike><span
									class="dollar">$</span>1250,00</strike>
							</p>
						</div>
						<div class="bottom"></div>
					</div>
					<div class="product-bottom"></div>
				</div>
			</div>
			<div class="cl"></div>
		</div>
		<!-- END Products -->
	</div>
	<!-- END Content -->
	<div class="cl"></div>
	</div>
	<!-- END Main -->


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

	</div>
	<p>
		<a href="linksCadastros.jsp">Links para Cadastros</a>
	</p>

</body>
</html>