package br.edu.ufabc.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ufabc.ecommerce.dao.CategoriaDAO;
import br.edu.ufabc.ecommerce.dao.ImagemDAO;
import br.edu.ufabc.ecommerce.dao.ProdutoDAO;
import br.edu.ufabc.ecommerce.model.Categoria;
import br.edu.ufabc.ecommerce.model.Imagem;
import br.edu.ufabc.ecommerce.model.Produto;

@Controller
public class ProdutoController {

	@RequestMapping("/")
	public String indexSemParametro(@RequestParam(defaultValue = "0") Long idCategoria,
			@RequestParam(defaultValue = "1") char order, @RequestParam(defaultValue = "0") Long idFabricante,
			Model model) {
		// categoria 0 significa que os produtos de todas as categorias serão
		// carregados
		// 1 = Modelo, 2 = Preço
		model.addAttribute("fabricanteSelecionado", idFabricante);
		model.addAttribute("categoriaSelecionada", idCategoria);
		
		model.addAttribute("order", order);
		return "index";
	}

	@RequestMapping("/index")
	public String indexComParametro(@RequestParam(defaultValue = "0") Long idCategoria,
			@RequestParam(defaultValue = "1") char order, @RequestParam(defaultValue = "0") Long idFabricante,
			Model model) {
		// categoria 0 significa que os produtos de todas as categorias serão
		// carregados
		// 1 = Modelo, 2 = Preço
		model.addAttribute("fabricanteSelecionado", idFabricante);
		model.addAttribute("categoriaSelecionada", idCategoria);
		model.addAttribute("order", order);
		return "index";
	}

	@RequestMapping("/produtoDetalhes")
	public String produtoDetalhes(@RequestParam Long id, Model model) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produtoSelecionado = produtoDAO.buscaProdutoPeloID(id);
		List<Imagem> listaImagens = new ArrayList<Imagem>();
		// procura todas as imagens do produto em questão
		listaImagens = produtoDAO.buscaImagens(produtoSelecionado);
		model.addAttribute("produtoSelecionado", produtoSelecionado);
		model.addAttribute("listaImagens", listaImagens);
		return "produto_detalhes";
	}

}