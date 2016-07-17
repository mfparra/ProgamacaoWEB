package br.edu.ufabc.ecommerce.model;

import java.sql.Date;

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

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataPedido() {
		return this.dataPedido;
	}

	public void setDataPedido(Date data) {
		this.dataPedido = data;
	}
}
