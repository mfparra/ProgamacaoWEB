package br.edu.ufabc.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.ecommerce.jdbc.ConexaoBD;
import br.edu.ufabc.ecommerce.model.Categoria;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO() {
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

	// insere uma categoria
	public void insere(Categoria categoria) {
		String sql = "insert into Categoria (nome, descricao) values (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta valores na tabela Produto
			stmt.setString(1, categoria.getNome());
			stmt.setString(2, categoria.getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// remove uma categoria
	public void remove(Categoria categoria) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from categoria where id = ?");
			stmt.setLong(1, categoria.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// altera dados de uma categoria
	public void altera(Categoria categoria) {
		String sql = "update categoria set nome = ?, descricao = ? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, categoria.getNome());
			stmt.setString(2, categoria.getDescricao());
			stmt.setLong(3, categoria.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// faz a busca de categoria(s) pelo ID
	public Categoria buscaCategoriaPeloID(Long id) {
		Categoria categoria = new Categoria();
		PreparedStatement stmt;
		String sql = "select * from categoria where id = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				categoria.setId(id);
				categoria.setNome(rs.getString("nome"));
				categoria.setDescricao(rs.getString("descricao"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return categoria;
	}

	// devolve uma lista com todas as categorias
	public List<Categoria> getLista() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("select * from categoria order by nome");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getLong("id"));
				categoria.setNome(rs.getString("nome"));
				categoria.setDescricao(rs.getString("descricao"));
				categorias.add(categoria);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return categorias;
	}

}
