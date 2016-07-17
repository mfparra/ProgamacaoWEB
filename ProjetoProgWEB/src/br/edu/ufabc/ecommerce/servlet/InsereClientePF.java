package br.edu.ufabc.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.ecommerce.dao.ClienteDAO;
import br.edu.ufabc.ecommerce.dao.UsuarioDAO;
import br.edu.ufabc.ecommerce.model.Cliente;
import br.edu.ufabc.ecommerce.model.Usuario;

@WebServlet("/cadastroPessoaFisica")
public class InsereClientePF extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		// obtem parametros do request para Tabela Cliente
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String telefone = req.getParameter("telefone");
		String RG = req.getParameter("RG");
		String CPF = req.getParameter("CPF");
		
		// obtem parametros do request para Tabela Usuário
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		// instancia Cliente
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		cliente.setRg(RG);
		cliente.setCpf(CPF);
		
		//Instância Usuário
		Usuario user = new Usuario();
		user.setLogin(login);
		user.setSenha(senha);
		user.setCpf(CPF);
		
		
		//Salvando do Banco
		ClienteDAO clienteDAO = new ClienteDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		clienteDAO.insere(cliente);
		usuarioDAO.insere(cliente, user);
		
		
		// escreve a pagina que sera enviada como resposta
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Aluno " + cliente.getNome() + " inserido com sucesso!<h2>");
		out.println("</body>");
		out.println("</html>");
	}
}
