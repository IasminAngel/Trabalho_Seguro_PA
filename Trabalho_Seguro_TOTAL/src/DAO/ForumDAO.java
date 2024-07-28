
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ForumDAO {
    private Connection conexao;
    
    public ForumDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void reclamacao(String registros) throws SQLException {
    String sql = "INSERT INTO forum SET registros = ?";

    try (PreparedStatement statement = conexao.prepareStatement(sql)) {
        statement.setString(1, registros);
        
        int rowsAffected = statement.executeUpdate();
        
        System.out.println("Rows affected: " + rowsAffected);
    } catch (SQLException e) {
        e.printStackTrace();
        throw new SQLException("Erro ao inserir a reclamação", e);
    }
}

    }
