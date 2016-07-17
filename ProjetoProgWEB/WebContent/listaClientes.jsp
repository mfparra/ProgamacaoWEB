<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Clientes</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp" />
	<h2>Clientes</h2>
	<jsp:useBean id="bd" class="br.edu.ufabc.ecommerce.dao.ClienteDAO" />
	<div id="lista-clientes">
		<table>
			<tr>
				<th>Tipo do Cliente</th>
				<th>Documento</th>
				<th>Nome/Razão Social</th>
				<th>e-mail</th>
				<th>Endereço</th>
				<th>CEP</th>
				<th>Telefone</th>
			</tr>

			<c:forEach items="${bd.lista}" var="cliente">
			<input type="hidden" value="cliente.id"/>
				<tr>
					<c:choose>
						<c:when test="${cliente.tipoCliente == 'F'}">
							<td>Físico</td>
							<td>CPF: ${cliente.cpf}</td>
							<td>${cliente.nome}</td>
						</c:when>
						<c:when test="${cliente.tipoCliente == 'J'}">
							<td>Jurídico</td>
							<td>CNPJ: ${cliente.cnpj}</td>
							<td>${cliente.razaoSocial}</td>
						</c:when>
					</c:choose>
					<td>${cliente.email}</td>
					<td>${cliente.endereco}</td>
					<td>${cliente.cep}</td>
					<td>${cliente.telefone}</td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<a id="inserir" href="insereCliente.jsp">Novo Cliente</a><br />
		</p>
		
		<p>
			<a href="index.jsp">Voltar</a>
		</p>
		
	</div>
</body>
</html>