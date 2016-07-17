package br.edu.ufabc.ecommerce.model;

public class Produto {
	private Long id;
	private Categoria categoria;
	private Fabricante fabricante;
	private Long durBateria, tamTela;
	private Double valor;
	private String modelo, descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDurBateria() {
		return durBateria;
	}

	public void setDurBateria(Long durBateria) {
		this.durBateria = durBateria;
	}

	public Long getTamTela() {
		return tamTela;
	}

	public void setTamTela(Long tamTela) {
		this.tamTela = tamTela;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
