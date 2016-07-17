package br.edu.ufabc.ecommerce.acao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.ecommerce.dao.ClienteDAO;
import br.edu.ufabc.ecommerce.model.Cliente;

public class ExcluiCliente implements Acao {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// obtem ID do cliente na request
		String id = req.getParameter("id");
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscaClientePeloID(Long.getLong(id));
		clienteDAO.remove(cliente);
		req.setAttribute("msg", "Cliente " + cliente.getNome() + " removido com sucesso!");
		return "/index.jsp";
	}

}
