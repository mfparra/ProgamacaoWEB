package br.edu.ufabc.ecommerce.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
	private static Connection conn = null;

	public Connection getConexaoBD() {
		// conectando ao Banco de Dados usando JDBC
		try {
			if (conn == null) {
				String url = "jdbc:mysql://localhost/ecommerce";
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, "root", "root");
			}
			return conn;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
