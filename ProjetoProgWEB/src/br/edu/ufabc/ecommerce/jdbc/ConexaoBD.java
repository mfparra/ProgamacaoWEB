package br.edu.ufabc.ecommerce.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

	public Connection getConexaoBD() {
		//conectando ao Banco de Dados usando JDBC
		try {
			String url = "jdbc:mysql://localhost/ecommerce";
			return DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
