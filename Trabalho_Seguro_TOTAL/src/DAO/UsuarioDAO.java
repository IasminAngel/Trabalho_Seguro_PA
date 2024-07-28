package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conexao;

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void alterarUsuario(int matricula, String senha) throws SQLException {
        String sql = "UPDATE Funcionario SET senha = ? WHERE Matricula = ?";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, senha);
            statement.setInt(2, matricula);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao alterar o usuário", e);
        }
    }

    public String login(String senha, int matricula) throws SQLException {
        String sql = "SELECT cargo FROM funcionario WHERE matricula = ? AND senha = ?";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, matricula);
            statement.setString(2, senha);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getString("cargo");
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao realizar login", e);
        }
    }
}
