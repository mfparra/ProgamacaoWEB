package br.edu.ufabc.projetoWEB.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.edu.ufabc.projetoWEB.bancoDados.ClienteBD;
import br.edu.ufabc.projetoWEB.modelo.Cliente;
import br.edu.ufabc.projetoWEB.modelo.Usuario;

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
		int RG = Integer.parseInt(req.getParameter("RG"));
		int CPF = Integer.parseInt(req.getParameter("CPF"));
		
		// obtem parametros do request para Tabela Usuário
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		// instancia Cliente
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		cliente.setRG(RG);
		cliente.setCPF(CPF);
		
		//Instância Usuário
		Usuario user = new Usuario();
		user.setLogin(login);
		user.setSenha(senha);
		user.setCPF(CPF);
		
		
		//Salvando do Banco
		ClienteBD insCli = new ClienteBD();
		insCli.insereTabelaCliente(cliente);
		insCli.insereTabelaUsuario(cliente, user);
		
		
		// escreve a pagina que sera enviada como resposta
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Aluno " + cliente.getNome() + " inserido com sucesso!<h2>");
		out.println("</body>");
		out.println("</html>");
	}
}
