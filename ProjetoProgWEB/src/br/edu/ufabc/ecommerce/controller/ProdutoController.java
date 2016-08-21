package br.edu.ufabc.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/detalhes")
	public String detalhes() {
		// this.=
		// this.jogoService.recuperarComListas(this.jogoSelecionado.getId());
		return "produto_detalhes";
	}

}