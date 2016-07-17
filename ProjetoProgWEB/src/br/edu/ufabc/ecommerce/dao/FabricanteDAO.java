package br.edu.ufabc.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.ecommerce.jdbc.ConexaoBD;
import br.edu.ufabc.ecommerce.model.Fabricante;

public class FabricanteDAO {

	private Connection connection;

	public FabricanteDAO() {
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

	// insere uma fabricante
	public void insere(Fabricante fabricante) {
		String sql = "insert into Fabricante (nome) values (?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta valores na tabela Produto
			stmt.setString(1, fabricante.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// remove uma fabricante
	public void remove(Fabricante fabricante) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from fabricante where id = ?");
			stmt.setLong(1, fabricante.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// altera dados de uma fabricante
	public void altera(Fabricante fabricante) {
		String sql = "update fabricante set nome = ? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, fabricante.getNome());
			stmt.setLong(2, fabricante.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// faz a busca de fabricante(s) pelo ID
	public Fabricante buscaFabricantePeloID(Long id) {
		Fabricante fabricante = new Fabricante();
		PreparedStatement stmt;
		String sql = "select * from fabricante where id = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				fabricante.setId(id);
				fabricante.setNome(rs.getString("nome"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return fabricante;
	}

	// devolve uma lista com todos os fabricantes
	public List<Fabricante> getLista() {
		List<Fabricante> fabricantes = new ArrayList<Fabricante>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("select * from fabricante order by nome");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fabricante fabricante = new Fabricante();
				fabricante.setId(rs.getLong("id"));
				fabricante.setNome(rs.getString("nome"));
				fabricantes.add(fabricante);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return fabricantes;
	}

}
