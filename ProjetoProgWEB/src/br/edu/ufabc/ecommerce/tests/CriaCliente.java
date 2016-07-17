package br.edu.ufabc.ecommerce.tests;

import br.edu.ufabc.ecommerce.dao.ClienteDAO;
import br.edu.ufabc.ecommerce.model.Cliente;

public class CriaCliente {
	public static void main(String args[]) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Guilhermino");
		cliente.setTipoCliente("F");
		cliente.setEmail("guilher@gmail.com");
		cliente.setEndereco("Rua das Avenidas");
		cliente.setTelefone("21551200");
		cliente.setRg("493929495");
		cliente.setCpf("123123123");
		cliente.setRazaoSocial("123");
		cliente.setCnpj("12453");
		
		ClienteDAO cli = new ClienteDAO();
		cli.insere(cliente);
		System.out.println("teste");
	}

}
