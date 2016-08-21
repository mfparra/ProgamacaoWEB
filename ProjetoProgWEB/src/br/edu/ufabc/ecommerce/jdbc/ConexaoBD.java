package br.edu.ufabc.ecommerce.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	public Connection getConexaoBD() {
		// conectando ao Banco de Dados usando JDBC
		try {
			String url = "jdbc:mysql://localhost/ecommerce";
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
