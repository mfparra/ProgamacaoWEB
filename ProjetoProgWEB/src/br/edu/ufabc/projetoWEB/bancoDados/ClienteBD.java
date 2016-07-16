package br.edu.ufabc.projetoWEB.bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ufabc.projetoWEB.jdbc.ConexaoBD;
import br.edu.ufabc.projetoWEB.modelo.Cliente;
import br.edu.ufabc.projetoWEB.modelo.Usuario;

public class ClienteBD {
	private Connection connection;

	public ClienteBD() {
		// cria uma conexao com o BD
		this.connection = new ConexaoBD().getConnection();
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
		String sql_cliente = "insert into Cliente (nome,email,endereco,telefone,RG,CPF,rasaoSocial,CNPJ) values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql_cliente);
			// seta valores na tabela Cliente
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getTelefone());
			stmt.setInt(5, cliente.getRG());
			stmt.setInt(6, cliente.getCPF());
			stmt.setString(7, cliente.getRasaoSocial());
			stmt.setInt(6, cliente.getCNPJ());
			stmt.execute();

			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Insere um Usuário
	public void insereTabelaUsuario(Cliente cliente, Usuario user) {
		String sql_usuario = "insert into Usuario(id_cliente, login, senha, nome, CPF) values (?,?,?,?,?)";
		try {
			PreparedStatement stmt;
			// seta valores na tabela Usuario/////////
			// Busca pelo ID gerado pelo banco de Dados
			String busca_id = "select id from Cliente where CPF = ? or CNPJ = ?";
			stmt = connection.prepareStatement(busca_id);
			stmt.setInt(1, cliente.getCPF());
			stmt.setInt(2, cliente.getCNPJ());
			ResultSet rs = stmt.executeQuery();
			user.setId_cliente(rs.getInt("id"));

			// Insere os dados na Tabela do Usuário
			stmt = connection.prepareStatement(sql_usuario);
			stmt.setInt(1, cliente.getId());
			stmt.setString(2, user.getLogin());
			stmt.setString(3, user.getSenha());
			stmt.setString(4, user.getNome());
			stmt.setInt(5, user.getCPF());
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
			user.setCPF(rs.getInt("CPF"));
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}

}
