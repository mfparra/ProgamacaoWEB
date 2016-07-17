<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Cliente</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp" />
	<jsp:useBean id="categorias" class="br.edu.ufabc.ecommerce.dao.CategoriaDAO" />
	<jsp:useBean id="fabricantes" class="br.edu.ufabc.ecommerce.dao.FabricanteDAO" />
	

	<form action="controller" method="post">
		Categoria:
		<select name="categoria">
			<c:forEach items="${categorias.lista}" var="categoria">
				<option value="${categoria.id}">${categoria.nome}</option>
			</c:forEach>
		</select>
		<br>
		Fabricante:
		<select name="fabricante">
			<c:forEach items="${fabricantes.lista}" var="fabricante">
				<option value="${fabricante.id}">${fabricante.nome}</option>
			</c:forEach>
		</select><br/>
		Modelo:
		<input type="text" name="modelo" /> <br>
		Descrição:
		<input type="text" name="descricao" /> <br>
		Duração da Bateria:
		<input type="text" name="durBateria" /> <br>
		Tamanho da Tela:
		<input type="text" name="tamTela" /> <br>
		Valor:
		<input type="text" name="valor" /> <br>
		
		<input type="submit" value="Gravar" />
		<input type="hidden" name="opcao" value="InsereProduto" />	
	</form>
	
	<p>
			<a href="index.jsp">Voltar</a>
	</p>
	
</body>
</html>