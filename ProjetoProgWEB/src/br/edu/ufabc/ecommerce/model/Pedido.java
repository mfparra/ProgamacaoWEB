package br.edu.ufabc.ecommerce.model;

import java.sql.Timestamp;

public class Pedido {
	private Long id;
	private Cliente cliente;
	
	//o Timestamp é um tipo de dado que inclui dia e horário
	private Timestamp dataPedido;

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

	public Timestamp getDataPedido() {
		return this.dataPedido;
	}

	public void setDataPedido(Timestamp data) {
		this.dataPedido = data;
	}
}
