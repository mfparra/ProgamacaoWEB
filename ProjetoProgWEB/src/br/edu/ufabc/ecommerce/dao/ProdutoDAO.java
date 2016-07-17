package br.edu.ufabc.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.ecommerce.jdbc.ConexaoBD;
import br.edu.ufabc.ecommerce.model.Produto;

public class ProdutoDAO {
	private Connection connection;

	public ProdutoDAO() {
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

	// insere um produto
	public void insere(Produto produto) {
		String sql = "insert into Produto (id_categoria, id_fabricante, modelo, descricao, valor, duracaoBateria, tamanhoTela) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta valores na tabela Produto
			stmt.setLong(1, produto.getCategoria().getId());
			stmt.setLong(2, produto.getFabricante().getId());
			stmt.setString(3, produto.getModelo());
			stmt.setString(4, produto.getDescricao());
			stmt.setDouble(5, produto.getValor());
			stmt.setLong(6, produto.getDurBateria());
			stmt.setLong(7, produto.getTamTela());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// remove um produto
	public void remove(Produto produto) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from produto where id = ?");
			stmt.setLong(1, produto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// altera dados de um produto
	public void altera(Produto produto) {
		String sql = "update produto set id_categoria = ?, id_fabricante = ?, modelo = ?, descricao = ?, valor = ?, duracaoBateria = ?, tamanhoTela = ? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, produto.getCategoria().getId());
			stmt.setLong(2, produto.getFabricante().getId());
			stmt.setString(3, produto.getModelo());
			stmt.setString(4, produto.getDescricao());
			stmt.setDouble(5, produto.getValor());
			stmt.setLong(6, produto.getDurBateria());
			stmt.setLong(7, produto.getTamTela());
			stmt.setLong(8, produto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// faz a busca de produto(s) pelo ID
	public Produto buscaProdutoPeloID(Long id) {
		Produto produto = new Produto();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		PreparedStatement stmt;
		String sql = "select * from produto where id = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				produto.setId(id);
				produto.setCategoria(categoriaDAO.buscaCategoriaPeloID(rs.getLong("id_categoria")));
				produto.setDescricao(rs.getString("descricao"));
				produto.setDurBateria(rs.getLong("duracaoBateria"));
				produto.setFabricante(fabricanteDAO.buscaFabricantePeloID(rs.getLong("id_fabricante")));
				produto.setModelo(rs.getString("modelo"));
				produto.setTamTela(rs.getLong("tamanhoTela"));
				produto.setValor(rs.getDouble("valor"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return produto;
	}

	// faz a busca de produto(s) pelo modelo
	public List<Produto> buscaProdutoPeloModelo(String modelo) {
		List<Produto> produtos = new ArrayList<Produto>();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		PreparedStatement stmt;
		String sql = "select * from produto where modelo = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, modelo);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setModelo(modelo);
				produto.setId(rs.getLong("id"));
				produto.setCategoria(categoriaDAO.buscaCategoriaPeloID(rs.getLong("id_categoria")));
				produto.setDescricao(rs.getString("descricao"));
				produto.setDurBateria(rs.getLong("duracaoBateria"));
				produto.setFabricante(fabricanteDAO.buscaFabricantePeloID(rs.getLong("id_fabricante")));
				produto.setTamTela(rs.getLong("tamanhoTela"));
				produto.setValor(rs.getDouble("valor"));
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return produtos;
	}

	// devolve uma lista com todos produtos
	public List<Produto> getLista() {
		List<Produto> produtos = new ArrayList<Produto>();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("select * from produto order by modelo");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setCategoria(categoriaDAO.buscaCategoriaPeloID(rs.getLong("id_categoria")));
				produto.setModelo(rs.getString("modelo"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setDurBateria(rs.getLong("duracaoBateria"));
				produto.setFabricante(fabricanteDAO.buscaFabricantePeloID(rs.getLong("id_fabricante")));
				produto.setTamTela(rs.getLong("tamanhoTela"));
				produto.setValor(rs.getDouble("valor"));
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return produtos;
	}

}
