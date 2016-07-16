package br.edu.ufabc.ecommerce.tests;

import br.edu.ufabc.ecommerce.database.ClienteBD;
import br.edu.ufabc.ecommerce.model.Cliente;

public class CriaCliente {
	public static void main(String args[]) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Guilhermino");
		cliente.setTipoCliente('F');
		cliente.setEmail("guilher@gmail.com");
		cliente.setEndereco("Rua das Avenidas");
		cliente.setTelefone("21551200");
		cliente.setRG("493929495");
		cliente.setCPF("123123123");
		cliente.setRazaoSocial("123");
		cliente.setCNPJ("12453");
		
		ClienteBD cli = new ClienteBD();
		cli.insereTabelaCliente(cliente);
		System.out.println("teste");
	}

}
