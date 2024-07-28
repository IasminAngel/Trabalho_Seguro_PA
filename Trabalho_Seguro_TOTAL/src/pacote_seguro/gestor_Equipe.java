package pacote_seguro;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class gestor_Equipe {

    incidentes incidentes = new incidentes();

    public static void main(String[] args) {
        gestor_Equipe gestor = new gestor_Equipe();
        gestor.run();
    }

    public void run() {
        JFrame frame = new JFrame();
        while (true) {
            exibirMenuPrincipal(frame);
        }
    }

    public void exibirMenuPrincipal(Component frame) {
        Object[] opcoes = {"Verificar perfil", "Outra opção", "Sair"};
        int escolha = JOptionPane.showOptionDialog(frame, "Selecione uma opção:", "Escolha",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == JOptionPane.YES_OPTION) {
            verificarPerfil(frame);
        } else if (escolha == JOptionPane.NO_OPTION) {
            exibirMenuIncidente(frame);
        } else if (escolha == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }
    }

    private void verificarPerfil(Component frame) {
        String matricula;
        boolean validacao = false;

        do {
            matricula = JOptionPane.showInputDialog(null, "Verificando perfil: Digite a matrícula do funcionário");

            if (matricula == null) {
                return; // Volta para o menu principal
            } else if (matricula.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Digite novamente! Matrícula não pode estar vazia.");
            } else {
                try {
                    int numero_matricula = Integer.parseInt(matricula);
                    validacao = true;

                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho_seguro_sql", "root", "")) {
                        String sql = "SELECT * FROM funcionario WHERE matricula = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                            pstmt.setInt(1, numero_matricula);
                            try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) {
                                    String nome = rs.getString("nome");
                                    String sobrenome = rs.getString("sobrenome");
                                    String cargo = rs.getString("cargo");
                                    Date dtNascimento = rs.getDate("dtNascimento");
                                    String formacao = rs.getString("formacao");
                                    String CPF = rs.getString("CPF");
                                    String numero = rs.getString("numero");
                                    String DDD = rs.getString("DDD");
                                    String bairro = rs.getString("bairro");
                                    String logradouro = rs.getString("logradouro");
                                    String cidade = rs.getString("cidade");
                                    String telefoneEmergencial = rs.getString("telefone_emergencial");

                                    JOptionPane.showMessageDialog(frame, "Nome: " + nome + "\nSobrenome: " + sobrenome + "\nCargo: " + cargo + "\nData de Nascimento: " + dtNascimento + "\nFormação: " + formacao + "\nCPF: " + CPF + "\nDDD: " + DDD + "\nNúmero: " + numero + "\nBairro: " + bairro + "\nCidade: " + cidade + "\nTelefone Emergencial: " + telefoneEmergencial);
                                } else {
                                    JOptionPane.showMessageDialog(frame, "Funcionário não encontrado.");
                                    validacao = false;
                                }
                            }
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(frame, "Erro de conexão ao banco de dados: " + e.getMessage());
                        validacao = false;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Digite novamente! Matrícula deve ser um número!");
                }
            }
        } while (!validacao);

        int observacaoFuncionario = JOptionPane.showConfirmDialog(null, "Deseja adicionar uma observação para o funcionário selecionado?");
        if (observacaoFuncionario == JOptionPane.YES_OPTION) {
            adicionarObservacao(frame);
        } else if (observacaoFuncionario == JOptionPane.NO_OPTION) {
            exibirMenuIncidente(frame);
        }
    }

    public void exibirMenuIncidente(Component frame) {
        Object[] opcoes = {"Informar Incidente", "Outra opção", "Voltar ao Menu Principal"};
        int escolha = JOptionPane.showOptionDialog(frame, "Selecione uma opção:", "Escolha",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == JOptionPane.YES_OPTION) {
            informarIncidente(frame);
        } else if (escolha == JOptionPane.NO_OPTION) {
            epis epis = new epis();
            epis.EPIS(frame);
        } else if (escolha == JOptionPane.CANCEL_OPTION) {
            return; 
        }
    }

    private void informarIncidente(Component frame) {
        incidentes.registro_Incidente(frame);
    }

    private void adicionarObservacao(Component frame) {
        JFrame local = new JFrame("Digite o Status do usuário:");
        local.setSize(400, 300);
        local.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        local.setLayout(null);

        JLabel label = new JLabel("Digite o status:");
        JOptionPane.showMessageDialog(frame, "Coloque o desempenho do funcionário, Status na ala em que trabalha (Regular, Irregular ou Troca de Ala) ");
        JOptionPane.showMessageDialog(frame, "Observação: Após o segundo clique, sua informação será mandada para o nosso sistema!");

        label.setBounds(20, 20, 200, 20);
        local.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(120, 20, 200, 20);
        local.add(textField);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(20, 50, 300, 150);
        local.add(textArea);

        JButton button = new JButton("Clique aqui");
        button.setBounds(150, 220, 100, 30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textoDigitado = textField.getText();
                textArea.append(textoDigitado + "\n");
                textField.setText("");

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String textoDigitado = textField.getText();
                        textArea.append(textoDigitado + "\n");
                        textField.setText("");
                        local.dispose();
                        JOptionPane.showMessageDialog(frame, "Observação adicionada, Trabalho seguro sempre com você! =D");
                
                    }
                });
            }
        });

        local.add(button);
        local.setVisible(true);
    }

    public void finalizacao(Component frame) {
        JOptionPane.showMessageDialog(frame, "Não há mais opções, caso queira recomeçar, apenas dê um clique! Obrigado por acessar Trabalho Seguro =) !");
    }
}
