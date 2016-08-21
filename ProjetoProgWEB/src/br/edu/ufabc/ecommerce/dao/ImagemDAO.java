package br.edu.ufabc.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.ecommerce.jdbc.ConexaoBD;
import br.edu.ufabc.ecommerce.model.Imagem;
import br.edu.ufabc.ecommerce.model.Produto;

public class ImagemDAO {

	private Connection connection;

	public ImagemDAO() {
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

	// insere uma imagem
	public void insere(Imagem imagem) {
		String sql = "insert into Imagem (id_produto, imagem) values (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta valores na tabela Produto
			stmt.setLong(1, imagem.getProduto().getId());
			stmt.setString(2, imagem.getLink());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// remove um imagem
	public void remove(Imagem imagem) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from imagem where id = ?");
			stmt.setLong(1, imagem.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// altera dados de um imagem
	public void altera(Imagem imagem) {
		String sql = "update imagem set imagem = ? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, imagem.getLink());
			stmt.setLong(2, imagem.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// faz a busca de imagem pelo ID
	public Imagem buscaImagemPeloID(Long id) {
		Imagem imagem = new Imagem();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		PreparedStatement stmt;
		String sql = "select * from imagem where id = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				imagem.setId(id);
				imagem.setLink(rs.getString("imagem"));
				imagem.setProduto(produtoDAO.buscaProdutoPeloID(rs.getLong("id_produto")));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return imagem;
	}
	
	// devolve uma lista com todas as imagens de um produto
		public List<Imagem> getImagens(Produto produto) {
			List<Imagem> imagens = new ArrayList<Imagem>();
			ProdutoDAO produtoDAO = new ProdutoDAO();
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement("select * from imagem where id_produto = ?");
				stmt.setLong(1, produto.getId());
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Imagem imagem = new Imagem();
					imagem.setId(rs.getLong("id"));
					imagem.setProduto(produtoDAO.buscaProdutoPeloID(rs.getLong("id_produto")));
					imagem.setLink(rs.getString("imagem"));
					imagens.add(imagem);
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return imagens;
		}
	
	// faz a busca de imagem pelo ID
		public String getLink(Long idProduto) {
			Imagem imagem = new Imagem();
			ProdutoDAO produtoDAO = new ProdutoDAO();
			PreparedStatement stmt;
			String sql = "select * from imagem where id_produto = ? order by id desc";
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setLong(1, idProduto);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					imagem.setId(idProduto);
					imagem.setLink(rs.getString("imagem"));
					imagem.setProduto(produtoDAO.buscaProdutoPeloID(rs.getLong("id_produto")));
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return imagem.getLink();
		}

}
