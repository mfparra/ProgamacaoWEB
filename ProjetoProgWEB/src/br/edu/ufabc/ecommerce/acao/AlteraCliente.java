package br.edu.ufabc.ecommerce.acao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.ecommerce.dao.ClienteDAO;
import br.edu.ufabc.ecommerce.model.Cliente;

public class AlteraCliente implements Acao {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// obtem parametros do request para tabela de clientes
		String id = req.getParameter("id");
		String tipoCliente = req.getParameter("tipoCliente");
		String nome = req.getParameter("nome");
		String razaoSocial = req.getParameter("razaoSocial");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String cep = req.getParameter("cep");
		String rg = req.getParameter("rg");
		String cpf = req.getParameter("cpf");
		String cnpj = req.getParameter("cnpj");
		String telefone = req.getParameter("telefone");

		// // obtem parametros do request para Tabela Usuário
		// String login = req.getParameter("login");
		// String senha = req.getParameter("senha");

		// instancia Cliente
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscaClientePeloID(Long.getLong(id));
		cliente.setNome(nome);
		cliente.setTipoCliente(tipoCliente);
		cliente.setRazaoSocial(razaoSocial);
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		cliente.setCep(cep);
		cliente.setRg(rg);
		cliente.setCpf(cpf);
		cliente.setCnpj(cnpj);
		cliente.setTelefone(telefone);

		// //Instância Usuário
		// Usuario user = new Usuario();
		// user.setLogin(login);
		// user.setSenha(senha);
		// user.setCpf(CPF);

		// Salvando no Banco
		// UsuarioDAO usuarioDAO = new UsuarioDAO();
		clienteDAO.altera(cliente);
		// usuarioDAO.insere(cliente, user);

		req.setAttribute("msg", "Cliente " + cliente.getNome() + " alterado com sucesso!");
		return "/index.jsp";
	}

}
