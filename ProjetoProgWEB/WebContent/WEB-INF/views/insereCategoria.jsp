<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Categoria</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp" />

	<form action="controller" method="post">
		<br>
		Nome:
		<input type="text" name="nome" /> <br>
		Descrição:
		<input type="text" name="descricao" /> <br>
	
		
		<input type="submit" value="Gravar" />
		<input type="hidden" name="opcao" value="InsereCategoria" />
		
	</form>
		<p>
			<a href="index.jsp">Voltar</a>
		</p>
	
</body>
</html>