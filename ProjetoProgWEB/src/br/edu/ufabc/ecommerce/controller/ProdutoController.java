package br.edu.ufabc.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ufabc.ecommerce.model.Produto;

@Controller
public class ProdutoController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("detalhes")
	public String detalhes(Produto produto) {
		return "detalhes";
	}
}