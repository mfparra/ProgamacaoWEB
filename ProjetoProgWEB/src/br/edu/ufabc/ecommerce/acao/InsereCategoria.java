package br.edu.ufabc.ecommerce.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.ecommerce.dao.CategoriaDAO;
import br.edu.ufabc.ecommerce.model.Categoria;

public class InsereCategoria implements Acao {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// obtem parametros do request para tabela de clientes
		String nome = req.getParameter("nome");
		String descricao = req.getParameter("descricao");

		// instancia categoria
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		categoria.setDescricao(descricao);

		// Salvando no Banco
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.insere(categoria);

		req.setAttribute("msg", "Categoria " + categoria.getNome() + " inserida com sucesso!");
		return "/listaCategorias.jsp";
	}

}
