package br.edu.ufabc.ecommerce.model;

public class Imagem {
	private Long id;
	private Long idProduto;
	private byte[] bytes;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public byte[] getBytes() {
		return this.bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

}
