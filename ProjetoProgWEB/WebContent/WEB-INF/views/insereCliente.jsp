<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Cliente</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp" />

	<form action="controller" method="post">
		Tipo de Cliente:
		<input type="radio" name="tipoCliente" value="F">Pessoa Física
		<input type="radio" name="tipoCliente" value="J">Pessoa Jurídica
		<br>
		Nome:
		<input type="text" name="nome" /> <br>
		Razão Social:
		<input type="text" name="razaoSocial" /> <br>
		e-mail:
		<input type="text" name="email" /> <br>
		Endereço:
		<input type="text" name="endereco" /> <br>
		CEP:
		<input type="text" name="cep" /> <br>
		RG:
		<input type="text" name="rg" /> <br>
		CPF:
		<input type="text" name="cpf" /> <br>
		CNPJ:
		<input type="text" name="cnpj"/> <br>
		Telefone:
		<input type="text" name="telefone"/> <br>
		
		<input type="submit" value="Gravar" />
		<input type="hidden" name="opcao" value="InsereCliente" />
		
	</form>
	<p>
		<a href="listaClientes.jsp">Exibir clientes cadastrados</a>
	</p>
	
	<p>
			<a href="index.jsp">Voltar</a>
	</p>
	
</body>
</html>