package principal;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		// Estabeleça uma conexão
		Connection connection = DatabaseConnection.getConnection();

		// Verifique se a conexão foi bem-sucedida
		if (connection != null) {
			System.out.println("Conexão bem-sucedida!");
		} else {
			System.out.println("Falha na conexão.");
		}
	}

}
