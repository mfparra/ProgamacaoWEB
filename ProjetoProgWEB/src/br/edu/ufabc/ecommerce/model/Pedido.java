package br.edu.ufabc.ecommerce.model;

import java.util.Date;

public class Pedido {
	private Long id;
	private Cliente cliente;
	private Date dataPedido;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getIdCliente() {
		return this.cliente;
	}

	public void setIdProduto(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return this.dataPedido;
	}

	public void setData(Date data) {
		this.dataPedido = data;
	}
}
