package br.edu.ufabc.ecommerce.model;

public class Cliente {
	private String nome, email, endereco, telefone, razaoSocial;
	private int id;
	private String RG, CPF, CNPJ;
	private char tipoCliente;
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCNPJ() {
		return this.CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		this.CNPJ = cNPJ;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRG() {
		return this.RG;
	}

	public void setRG(String rG) {
		this.RG = rG;
	}

	public String getCPF() {
		return this.CPF;
	}

	public void setCPF(String cPF) {
		this.CPF = cPF;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public char getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(char tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	 
}
