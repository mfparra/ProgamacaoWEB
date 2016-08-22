package br.edu.ufabc.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ufabc.ecommerce.dao.ImagemDAO;
import br.edu.ufabc.ecommerce.dao.ProdutoDAO;
import br.edu.ufabc.ecommerce.model.Imagem;
import br.edu.ufabc.ecommerce.model.Produto;

@Controller
public class ProdutoController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/produtoDetalhes")
	public String produtoDetalhes(@RequestParam Long id, Model model) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ImagemDAO imagemDAO = new ImagemDAO();
		Produto produtoSelecionado = produtoDAO.buscaProdutoPeloID(id);
		List<Imagem> listaImagens = new ArrayList<Imagem>();
		listaImagens = produtoDAO.buscaImagens(produtoSelecionado);
		model.addAttribute("produtoSelecionado", produtoSelecionado);
		model.addAttribute("listaImagens", listaImagens);
		return "produto_detalhes";
	}

}