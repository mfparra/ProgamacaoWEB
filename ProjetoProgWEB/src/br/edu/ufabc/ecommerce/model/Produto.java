package br.edu.ufabc.ecommerce.model;

public class Produto {
	private int id, durBateria, tamTela;
	private double valor;
	private String modelo, categoria, marca, descricao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDurBateria() {
		return durBateria;
	}
	public void setDurBateria(int durBateria) {
		this.durBateria = durBateria;
	}
	public int getTamTela() {
		return tamTela;
	}
	public void setTamTela(int tamTela) {
		this.tamTela = tamTela;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
