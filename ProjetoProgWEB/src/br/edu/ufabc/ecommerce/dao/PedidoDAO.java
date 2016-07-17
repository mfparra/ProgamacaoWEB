package br.edu.ufabc.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.ecommerce.jdbc.ConexaoBD;
import br.edu.ufabc.ecommerce.model.Pedido;

public class PedidoDAO {

	private Connection connection;

	public PedidoDAO() {
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

	// insere uma pedido
	public void insere(Pedido pedido) {
		String sql = "insert into Pedido (id_cliente, data) values (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta valores na tabela Produto
			stmt.setLong(1, pedido.getCliente().getId());
			stmt.setTimestamp(2, pedido.getDataPedido());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// remove uma pedido
	public void remove(Pedido pedido) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from pedido where id = ?");
			stmt.setLong(1, pedido.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// altera dados de uma pedido
	public void altera(Pedido pedido) {
		String sql = "update pedido set id_cliente = ?, data = ? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, pedido.getCliente().getId());
			stmt.setTimestamp(2, pedido.getDataPedido());
			stmt.setLong(3, pedido.getId());
			stmt.execute();
			stmt.close();

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// faz a busca de pedido(s) pelo ID
	public Pedido buscaPedidoPeloID(Long id) {
		Pedido pedido = new Pedido();
		ClienteDAO clienteDAO = new ClienteDAO();
		PreparedStatement stmt;
		String sql = "select * from pedido where id = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pedido.setId(id);
				pedido.setCliente(clienteDAO.buscaClientePeloID(rs.getLong("id_cliente")));
				pedido.setDataPedido(rs.getTimestamp("data"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return pedido;
	}

	// devolve uma lista com todos os pedidos
	public List<Pedido> getLista() {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		ClienteDAO clienteDAO = new ClienteDAO();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("select * from pedido order by data");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(rs.getLong("id"));
				pedido.setCliente(clienteDAO.buscaClientePeloID(rs.getLong("id_cliente")));
				pedido.setDataPedido(rs.getTimestamp("data"));
				pedidos.add(pedido);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return pedidos;
	}

}
