package br.edu.ufabc.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.ecommerce.jdbc.ConexaoBD;
import br.edu.ufabc.ecommerce.model.ItemPedido;
import br.edu.ufabc.ecommerce.model.Pedido;

public class ItemPedidoDAO {

	private Connection connection;

	public ItemPedidoDAO() {
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

	// insere uma itemPedido
	public void insere(ItemPedido itemPedido) {
		String sql = "insert into ItemPedido (id_pedido, id_produto, quantidade) values (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta valores na tabela Produto
			stmt.setLong(1, itemPedido.getPedido().getId());
			stmt.setLong(2, itemPedido.getProduto().getId());
			stmt.setLong(3, itemPedido.getQuantidade());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// remove um itemPedido
	public void remove(ItemPedido itemPedido) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from itemPedido where id = ?");
			stmt.setLong(1, itemPedido.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// altera dados de um itemPedido
	public void altera(ItemPedido itemPedido) {
		String sql = "update itemPedido set quantidade = ? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, itemPedido.getQuantidade());
			stmt.setLong(2, itemPedido.getId());
			stmt.execute();
			stmt.close();

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// devolve uma lista com todos os itens de um mesmo pedido
	public List<ItemPedido> getLista(Pedido pedido) {
		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("select * from itemPedido where pedido = ?");
			stmt.setLong(1, pedido.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ItemPedido itemPedido = new ItemPedido();
				itemPedido.setId(rs.getLong("id"));
				itemPedido.setPedido(pedido);
				itemPedido.setProduto(produtoDAO.buscaProdutoPeloID(rs.getLong("id_produto")));
				itemPedido.setQuantidade(rs.getInt("quantidade"));
				itensPedido.add(itemPedido);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return itensPedido;
	}

}
