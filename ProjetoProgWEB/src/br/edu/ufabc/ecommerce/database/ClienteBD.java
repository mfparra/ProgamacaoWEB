package br.edu.ufabc.ecommerce.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufabc.ecommerce.jdbc.ConexaoBD;
import br.edu.ufabc.ecommerce.model.Cliente;
import br.edu.ufabc.ecommerce.model.Usuario;

public class ClienteBD {
	private Connection connection;

	public ClienteBD() {
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

	// insere um Cliente
	public void insereTabelaCliente(Cliente cliente) {
		String sql_cliente = "insert into Cliente (nome,tipoCliente, email,endereco,telefone,rg,cpf,razaoSocial,cnpj) values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql_cliente);
			// seta valores na tabela Cliente
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, ""+cliente.getTipoCliente());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getTelefone());
			stmt.setString(6, cliente.getRG());
			stmt.setString(7, cliente.getCPF());
			stmt.setString(8, cliente.getRasaoSocial());
			stmt.setString(9, cliente.getCNPJ());
			stmt.execute();

			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Insere um Usuário
	public void insereTabelaUsuario(Cliente cliente, Usuario user) {
		String sql_usuario = "insert into Usuario(id_cliente, login, senha, nome, CPF) values (?,?,?,?,?)";
		try {
			PreparedStatement stmt;
			// seta valores na tabela Usuario/////////
			// Busca pelo ID gerado pelo banco de Dados
			String busca_id = "select id from Cliente where CPF = ? or CNPJ = ?";
			stmt = connection.prepareStatement(busca_id);
			stmt.setString(1, cliente.getCPF());
			stmt.setString(2, cliente.getCNPJ());
			ResultSet rs = stmt.executeQuery();
			user.setId_cliente(rs.getInt("id"));

			// Insere os dados na Tabela do Usuário
			stmt = connection.prepareStatement(sql_usuario);
			stmt.setInt(1, cliente.getId());
			stmt.setString(2, user.getLogin());
			stmt.setString(3, user.getSenha());
			stmt.setString(4, user.getNome());
			stmt.setString(5, user.getCPF());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// faz a busca de aluno(s) pelo Login do Usuario
	public Usuario buscaUserPeloLogin(String login) {
		Usuario user = new Usuario();
		PreparedStatement stmt;
		String sql = "select * from Usuario where login=?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			user.setId(rs.getInt("id"));
			user.setSenha(rs.getString("senha"));
			user.setCPF(rs.getString("CPF"));

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}

}
