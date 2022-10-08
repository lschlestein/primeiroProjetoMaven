package bd.executeQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		String db_url = "jdbc:mysql://localhost:3306/reuniao";// caminho de acesso ao banco de dados
		String db_query = "SELECT * FROM pessoa";// query a ser executada pelo banco de dados
		String db_user = "root";// usuário do SGBD
		String db_password = "";// senha do SGBD

		System.out.println("Iniciando conexao ao DB");
		// utilizando try com recursos para conexão e tratamento de exceções
		try (Connection c = DriverManager.getConnection(db_url, db_user, db_password);
				Statement statement = c.createStatement();
				ResultSet resultSet = statement.executeQuery(db_query);) {
			System.out.println("Conectado ao MySql");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
						+ "\t" + resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao conectar ao MySql");
		}

	}

}
