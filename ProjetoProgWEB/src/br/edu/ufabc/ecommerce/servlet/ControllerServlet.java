package br.edu.ufabc.ecommerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.ecommerce.acao.Acao;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opcao = req.getParameter("opcao");
		
		//encontra a classe
		String nomeDaClasse = "br.edu.ufabc.ecommerce.acao." + opcao;
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			//instancia um objeto para a classe (exemplo: InsereCliente)
			Acao acao = (Acao) classe.newInstance();
			String destino = acao.executa(req, resp);
			RequestDispatcher rd = req.getRequestDispatcher(destino);
			rd.forward(req, resp);
		} catch (Exception e) {
			throw new ServletException("Erro: ", e);
		}
	}
}
