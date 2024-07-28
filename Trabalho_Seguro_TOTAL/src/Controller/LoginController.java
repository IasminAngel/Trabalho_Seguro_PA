package Controller;
import DAO.UsuarioDAO;
import conexao.Conexao;
import login_view.CadastroView;
import login_view.LoginView;
import pacote_seguro.colaborador;
import pacote_seguro.gestor_Equipe;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;


public class LoginController {
    private Connection conexao;

    public LoginController() throws SQLException {
        this.conexao = new Conexao().getConexao();
    }

    public void alterarSenha(CadastroView view) throws SQLException {
        UsuarioDAO alterar = new UsuarioDAO(conexao);
        alterar.alterarUsuario(Integer.parseInt(view.getjTextPaneMatricula().getText()), view.getjPasswordSenhaNova().getText());
    }

    public void loginUsuario(LoginView view) throws SQLException {
        UsuarioDAO login = new UsuarioDAO(conexao);
        String cargo = login.login(view.getjPasswordFieldsenha().getText(), Integer.parseInt(view.getjTextFieldMatricula().getText()));

        if (cargo != null) {
            JOptionPane.showMessageDialog(view, "Login bem-sucedido!");
            view.dispose(); 

            // Redirecionar com base no cargo
            if (cargo.equalsIgnoreCase("COLABORADOR")) {
                colaborador colaborador = new colaborador();
                colaborador.colaborador_Opcoes(view);
            } else if (cargo.equalsIgnoreCase("GESTOR DE EQUIPE")) {
                gestor_Equipe gestor = new gestor_Equipe();
                gestor.exibirMenuPrincipal(view);
            } else {
                JOptionPane.showMessageDialog(view, "Cargo não reconhecido!");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Credenciais inválidas!");
        }
    }

    public void closeConnection() {
        if (this.conexao != null) {
            try {
                this.conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

