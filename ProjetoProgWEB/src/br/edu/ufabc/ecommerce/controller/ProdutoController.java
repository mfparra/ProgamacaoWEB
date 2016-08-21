package br.edu.ufabc.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ufabc.ecommerce.dao.ProdutoDAO;
import br.edu.ufabc.ecommerce.model.Produto;

@Controller
public class ProdutoController {

	private Produto produtoSelecionado;
    
    private ProdutoDAO produtoDAO;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("index")
	public String execute() {
		return "insereProduto";
	}

	
	@RequestMapping(value="detalhes", method=RequestMethod.GET)
	public String produtoDetalhes() {
		//this.produtoSelecionado = this.produtoDAO.buscaProdutoPeloID(this.produtoSelecionado.getId());
		return "jsp/produto_detalhes";
	}

}