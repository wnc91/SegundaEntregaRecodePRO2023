package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteController {
	private Connection connection;

	public ClienteController(Connection connection) {
		this.connection = connection;
	}

	public void adicionarCliente(Cliente cliente) {
		String sql = "INSERT INTO Cliente (CPF, Email, ID, Nome, Endereco, Telefone) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, cliente.getCpf());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setInt(3, cliente.getId());
			preparedStatement.setString(4, cliente.getNome());
			preparedStatement.setString(5, cliente.getEndereco());
			preparedStatement.setString(6, cliente.getTelefone());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean atualizarCliente(Cliente cliente) {
		String sql = "UPDATE Cliente SET CPF=?, Email=?, Nome=?, Endereco=?, Telefone=? WHERE ID=?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, cliente.getCpf());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getNome());
			preparedStatement.setString(4, cliente.getEndereco());
			preparedStatement.setString(5, cliente.getTelefone());

			int rowsUpdated = preparedStatement.executeUpdate();
			return rowsUpdated > 0; // Retorna true se a atualização foi bem-sucedida
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Retorna false em caso de erro
		} 
	}

	public Cliente exibirCliente(int id) {
		String sql = "SELECT * FROM Cliente WHERE ID=?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("ID"));
				cliente.setCpf(resultSet.getString("CPF"));
				cliente.setEmail(resultSet.getString("Email"));
				cliente.setNome(resultSet.getString("Nome"));
				cliente.setEndereco(resultSet.getString("Endereco"));
				cliente.setTelefone(resultSet.getString("Telefone"));
				return cliente; // Retorna o cliente encontrado
			} else {
				return null; // Retorna null se o cliente não foi encontrado
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null; // Retorna null em caso de erro
		}
	}
	
	public boolean excluirCliente(int id) {
	    String sql = "DELETE FROM Cliente WHERE ID=?";
	    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setInt(1, id);

	        int rowsDeleted = preparedStatement.executeUpdate();
	        return rowsDeleted > 0; // Retorna true se a exclusão foi bem-sucedida
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // Retorna false em caso de erro
	    }
	}


}
