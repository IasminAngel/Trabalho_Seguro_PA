package pacote_seguro;
import login_view.LoginView;

public class funcionario {
    public void interfaceFuncionario() {
        LoginView loginView = new LoginView();
        
        loginView.setVisible(true);
    }

    public static void main(String[] args) {
        // Cria uma instância da classe Funcionario e chama o método para abrir a tela de login
        funcionario funcionario = new funcionario();
        funcionario.interfaceFuncionario();
    }
}

       