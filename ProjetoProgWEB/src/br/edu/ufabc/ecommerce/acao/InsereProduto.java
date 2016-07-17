package br.edu.ufabc.ecommerce.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.ecommerce.dao.CategoriaDAO;
import br.edu.ufabc.ecommerce.dao.FabricanteDAO;
import br.edu.ufabc.ecommerce.dao.ProdutoDAO;
import br.edu.ufabc.ecommerce.model.Produto;

public class InsereProduto implements Acao {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// obtem parametros do request para tabela de produtos
		String categoria = req.getParameter("categoria");
		String modelo = req.getParameter("modelo");
		String descricao = req.getParameter("descricao");
		String durBateria = req.getParameter("durBateria");
		String fabricante = req.getParameter("fabricante");
		String tamTela = req.getParameter("tamTela");
		String valor = req.getParameter("valor");

		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// instancia categoria
		Produto produto = new Produto();
		produto.setCategoria(categoriaDAO.buscaCategoriaPeloID(Long.parseLong(categoria)));
		produto.setModelo(modelo);
		produto.setDescricao(descricao);
		produto.setDurBateria(Long.parseLong(durBateria));
		produto.setFabricante(fabricanteDAO.buscaFabricantePeloID(Long.parseLong(fabricante)));
		produto.setTamTela(Long.parseLong(tamTela));
		produto.setValor(Double.valueOf(valor));

		// Salvando no Banco
		produtoDAO.insere(produto);

		req.setAttribute("msg", "Produto " + produto.getModelo() + " inserido com sucesso!");
		return "/listaProdutos.jsp";
	}

}
