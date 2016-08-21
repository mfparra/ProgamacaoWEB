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

//	@Override
//	public String execute() throws Exception {
//		 = this.jogoService.listarTodos();
//		return "jsp/jogos_lista";
//	}

	public String detalhes() throws Exception {
//		this.= this.jogoService.recuperarComListas(this.jogoSelecionado.getId());
		return "produto_detalhes";
	}

}