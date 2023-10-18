package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DestinoController {
    private Connection connection;

    public DestinoController(Connection connection) {
        this.connection = connection;
    }

    public void adicionarDestino(Destino destino) {
        String sql = "INSERT INTO Destino (ID, Nome, Destino, Pais, Estado, Cidade) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, destino.getId());
            preparedStatement.setString(2, destino.getNome());
            preparedStatement.setString(3, destino.getDestino());
            preparedStatement.setString(4, destino.getPais());
            preparedStatement.setString(5, destino.getEstado());
            preparedStatement.setString(6, destino.getCidade());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarDestino(Destino destino) {
        String sql = "UPDATE Destino SET Nome=?, Destino=?, Pais=?, Estado=?, Cidade=? WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, destino.getNome());
            preparedStatement.setString(2, destino.getDestino());
            preparedStatement.setString(3, destino.getPais());
            preparedStatement.setString(4, destino.getEstado());
            preparedStatement.setString(5, destino.getCidade());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Destino lerDestino(int id) {
    	String sql = "SELECT * FROM Destino WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Destino destino = new Destino();
                destino.setId(resultSet.getInt("ID"));
                destino.setNome(resultSet.getString("Nome"));
                destino.setDestino(resultSet.getString("Destino"));
                destino.setPais(resultSet.getString("Pais"));
                destino.setEstado(resultSet.getString("Estado"));
                destino.setCidade(resultSet.getString("Cidade"));
                return destino; // Retorna o destino encontrado
            } else {
                return null; // Retorna null se o destino não foi encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro
        }
    }

    public void excluirDestino(int id) {
        String sql = "DELETE FROM Destino WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
