package br.edu.ufabc.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufabc.ecommerce.jdbc.ConexaoBD;
import br.edu.ufabc.ecommerce.model.Cliente;
import br.edu.ufabc.ecommerce.model.Usuario;

public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO() {
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

	// Insere um Usuário
	public void insere(Cliente cliente, Usuario user) {
		String sql_usuario = "insert into Usuario(id_cliente, login, senha, nome, cpf) values (?,?,?,?,?)";
		ClienteDAO clienteDAO = new ClienteDAO();
		try {
			PreparedStatement stmt;
			// seta valores na tabela Usuario//
			// Busca pelo ID gerado pelo banco de Dados
			String busca_id = "select id from Cliente where CPF = ? or CNPJ = ?";
			stmt = connection.prepareStatement(busca_id);
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getCnpj());
			ResultSet rs = stmt.executeQuery();
			user.setCliente(clienteDAO.buscaClientePeloID(rs.getLong("id")));

			// Insere os dados na Tabela do Usuário
			stmt = connection.prepareStatement(sql_usuario);
			stmt.setLong(1, user.getCliente().getId());
			stmt.setString(2, user.getLogin());
			stmt.setString(3, user.getSenha());
			stmt.setString(4, user.getNome());
			stmt.setString(5, user.getCpf());
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
			user.setId(rs.getLong("id"));
			user.setSenha(rs.getString("senha"));
			user.setCpf(rs.getString("CPF"));

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}

}
