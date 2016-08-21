<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Future Store - A melhor loja do Mundo</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="css/images/favicon.ico" />
<link rel="stylesheet" href="css/ecommerce2.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="css/ecommerce.css" type="text/css"
	media="all" />

<script src="js/jquery-1.7.min.js" type="text/javascript"></script>
<script src="js/jquery.jcarousel.js" type="text/javascript"></script>
<script src="js/DD_belatedPNG-min.js" type="text/javascript"></script>
<script src="js/functions.js" type="text/javascript"></script>
</head>
<body>
	<div class="shell">
		<jsp:useBean id="produtos"
			class="br.edu.ufabc.ecommerce.dao.ProdutoDAO" />
		<jsp:useBean id="categorias"
			class="br.edu.ufabc.ecommerce.dao.CategoriaDAO" />
		<jsp:useBean id="imagens"
			class="br.edu.ufabc.ecommerce.dao.ImagemDAO" />
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
				<h1 id="logo">
					<a title="home" href="#">Future Store</a>
				</h1>
				<!-- Search -->
				<div id="search">
					<form action="" method="post">
						<input type="text" class="field"
							value="Search entire store here..."
							title="Search entire store here..." /> <input type="submit"
							value="" class="submit-button" />
					</form>
				</div>
				<!-- END Search -->
			</div>
			<!-- END Header -->
			<!-- Navigation -->
			<div id="navigation">
				<c:forEach items="${categorias.lista}" var="categoria">
					<div class="categoria">
						<a href="#">${categoria.nome}</a>
					</div>
				</c:forEach>
				<div class="cl"></div>
			</div>
			<!-- END Navigation -->
			<!-- Main -->
			<div id="main">
				<!-- Slider -->
				<div id="slider-frame">
					<div id="slider">
						<ul>
							<c:forEach items="${produtos.getProdutoPromocao()}" var="produto">
							<li><img src="${imagens.getLink(produto.id)}" width="340" height="400"/>
								<div class="caption">
									<img src="http://i1255.photobucket.com/albums/hh638/Marcos_Freitas_Parra/promocao_1_zpsqeirxwuw.png" width="340" height="196"/>
									<p>${produto.modelo}</p>
									<a title="Comprar!" class="botaoComprar" href="#">Comprar</a>
								</div></li>
							</c:forEach>
							
							<li><img src="css/images/chair.png"
								alt="Orage rotating chair" />
								<div class="caption">
									<img src="css/images/mega-sale.png" alt="Mega Sale Sign" />
									<p>Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet</p>
									<a title="Order Now!" class="order-button" href="#">order
										now</a>
								</div></li>
						
						</ul>
						<div class="jcarousel-control">
							<a title="slide 1" href="#">1</a> <a title="slide 2" href="#">2</a>
							<a title="slide 3" href="#">3</a> <a title="slide 4" href="#">4</a>
						</div>
						<div class="slider-arrows">
							<a title="Next Slide" id="next" href="#">next</a> <a
								title="Previous Slide" id="prev" href="#">prev</a>
						</div>
					</div>
				</div>
				<!-- END Slider -->
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
								<li><a href="#">${categoria.nome}</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="box">
						<div class="title">
							<h2>Follow Us</h2>
							<img class="bullet" src="css/images/bullet.png"
								alt="small grey bullet" />
						</div>
						<ul class="socials">
							<li><a title="Facebook" href="#"><img
									src="css/images/fb.png" alt="facebook icon" />facebook</a></li>
							<li><a title="Tweeter" href="#"><img
									src="css/images/tweet.png" alt="tweeter icon" />twitter</a></li>
							<li><a title="Behance" href="#"><img
									src="css/images/behance.png" alt="behance icon" />behance</a></li>
							<li><a title="Blogger" href="#"><img
									src="css/images/blogger.png" alt="blogger icon" />blogger</a></li>
							<li><a title="Digg" href="#"><img
									src="css/images/digg.png" alt="digg icon" />digg</a></li>
						</ul>
					</div>
				</div>
				<!-- END Sidebar -->
				<!-- Content -->
				<div id="content">
					<!-- Products -->
					<div class="products">
						<div class="title">
							<h2>Todos os Produtos</h2>
							<a class="title-link" title="More Products" href="#">View
								More</a> <img class="bullet" src="css/images/bullet.png"
								alt="small grey bullet" />
						</div>
						<div class="row">
							<c:forEach items="${produtos.lista}" var="produto">
							
								<div class="product-holder">
									<div class="product">
										<a title="More Details" href="#">
										
										<img
											src="${imagens.getLink(produto.id)}" /></a>
										
										<div class="desc">
											<p>${produto.modelo}</p>
											<p class="price">
												<fmt:setLocale value="pt_BR" />
												<fmt:formatNumber type="currency" value="${produto.valor}" />
											</p>
										</div>
										<div class="bottom"></div>
									</div>
									<div class="product-bottom"></div>
								</div>
							</c:forEach>
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
									<a title="More Details" href="#"><img
										src="css/images/7.jpg" alt="Colourful armchairs" /></a>
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
									<a title="More Details" href="#"><img
										src="css/images/8.jpg" alt="Black classical armchair" /></a> <img
										class="new-label" src="css/images/new.png" alt="new sign" />
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
									<a title="More Details" href="#"><img
										src="css/images/9.jpg" alt="White sofa" /></a>
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
		</div>
		<!-- END Wrapper Middle -->
		<div id="wrapper-bottom"></div>
		<!-- Footer  -->
		<div id="footer">
			<span class="author"><a href="http://css-free-templates.com/">Design
					by: CSS Free Templates</a></span>
			<p>
				<a title="About Us" href="#">About Us</a><span>&frasl;&frasl;</span><a
					title="Site Map" href="#">Site Map</a><span>&frasl;&frasl;</span><a
					title="Advanced Search" href="#">Advanced Search</a><span>&frasl;&frasl;</span><a
					title="Customer Service" href="#">Customer Service</a><span>&frasl;&frasl;</span><a
					title="Contact Us" href="#">Contact Us</a><span>&frasl;&frasl;</span>
			</p>
		</div>
		<!-- END Footer -->
	</div>
</body>
</html>