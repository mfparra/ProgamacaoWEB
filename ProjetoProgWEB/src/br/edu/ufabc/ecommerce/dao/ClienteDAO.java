package br.edu.ufabc.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.ecommerce.jdbc.ConexaoBD;
import br.edu.ufabc.ecommerce.model.Cliente;

public class ClienteDAO {
	private Connection connection;

	public ClienteDAO() {
		// cria uma conexao com o BD
		this.connection = new ConexaoBD().getConexaoBD();
	}

	public void fechaConexao() {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// insere um cliente
	public void insere(Cliente cliente) {
		String sql = "insert into Cliente (tipoCliente, nome, razaoSocial, email, endereco, cep, rg, cpf, cnpj, telefone) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta valores na tabela Cliente
			stmt.setString(1, cliente.getTipoCliente().toString());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getRazaoSocial());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getEndereco());
			stmt.setString(6, cliente.getCep());
			stmt.setString(7, cliente.getRg());
			stmt.setString(8, cliente.getCpf());
			stmt.setString(9, cliente.getCnpj());
			stmt.setString(10, cliente.getTelefone());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// remove um cliente
	public void remove(Cliente cliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from cliente where id = ?");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// altera dados de um cliente
	public void altera(Cliente cliente) {
		String sql = "update cliente set tipoCliente = ?, nome = ?, razaoSocial = ?, email = ?, endereco = ?, cep = ?, "
				+ "rg = ?, cpf = ?, cnpj = ?, telefone = ? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getTipoCliente().toString());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getRazaoSocial());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getEndereco());
			stmt.setString(6, cliente.getCep());
			stmt.setString(7, cliente.getRg());
			stmt.setString(8, cliente.getCpf());
			stmt.setString(9, cliente.getCnpj());
			stmt.setString(10, cliente.getTelefone());
			stmt.setLong(11, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// faz a busca de cliente(s) pelo ID
		public Cliente buscaClientePeloID(Long id) {
			Cliente cliente = new Cliente();
			PreparedStatement stmt;
			String sql = "select * from cliente where id = ?";
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setLong(1, id);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					cliente.setId(id);
					cliente.setNome(rs.getString("nome"));
					cliente.setTipoCliente(rs.getString("tipoCliente"));
					cliente.setRazaoSocial(rs.getString("razaoSocial"));
					cliente.setEmail(rs.getString("email"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setCep(rs.getString("cep"));
					cliente.setRg(rs.getString("rg"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setCnpj(rs.getString("cnpj"));
					cliente.setTelefone(rs.getString("telefone"));
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return cliente;
		}
		
	// faz a busca de cliente(s) pelo nome do cliente
	public List<Cliente> buscaClientePeloNome(String nome) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		PreparedStatement stmt;
		String sql = "select * from cliente where nome = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTipoCliente(rs.getString("tipoCliente"));
				cliente.setRazaoSocial(rs.getString("razaoSocial"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setCep(rs.getString("cep"));
				cliente.setRg(rs.getString("rg"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setTelefone(rs.getString("telefone"));
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return clientes;
	}

	// devolve uma lista com todos clientes
	public List<Cliente> getLista() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("select * from cliente order by nome");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setTipoCliente(rs.getString("tipoCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setRazaoSocial(rs.getString("razaoSocial"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setCep(rs.getString("cep"));
				cliente.setRg(rs.getString("rg"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setTelefone(rs.getString("telefone"));
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return clientes;
	}

}
