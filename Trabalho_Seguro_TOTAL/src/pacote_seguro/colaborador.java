package pacote_seguro;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class colaborador {

    public void colaborador_Opcoes(Component frame) {

        JOptionPane.showMessageDialog(frame, "Seja Bem-Vindo colaborador =) De acordo com suas necessidades, selecione:");
        JFrame tela = new JFrame("Selecione uma opção:");
        tela.setSize(400, 300);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.setLayout(null);

        ButtonGroup grupoBotoes = new ButtonGroup();

        JRadioButton radio1 = new JRadioButton("Reclamação");
        radio1.setBounds(50, 50, 150, 30);
        grupoBotoes.add(radio1);
        tela.add(radio1);

        JRadioButton radio2 = new JRadioButton("Registrar Incidente");
        radio2.setBounds(50, 100, 200, 30);
        grupoBotoes.add(radio2);
        tela.add(radio2);

        JRadioButton radio3 = new JRadioButton("Iniciar conversa com gestor de equipe");
        radio3.setBounds(50, 150, 300, 30);
        grupoBotoes.add(radio3);
        tela.add(radio3);

        // botões
        JButton btnVerificar = new JButton("Criar categoria");
        btnVerificar.setBounds(200, 200, 150, 30);
        tela.add(btnVerificar);

        // FORUM
        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selecao = "";

                if (radio1.isSelected()) {
                    selecao = "Reclamação";
                } else if (radio2.isSelected()) {
                    selecao = "Registrar Incidente";
                } else if (radio3.isSelected()) {
                    selecao = "Iniciar conversa com gestor de equipe";
                }
                if (selecao.isEmpty()) {
                    selecao = "Nenhuma opção selecionada";
                }

                JOptionPane.showMessageDialog(tela, "Você selecionou: " + selecao);

                if (selecao.equals("Reclamação")) {

                    boolean validacao = false;

                    do {

                        String registros = JOptionPane.showInputDialog(frame, "Digite sua reclamação:");

                        if (registros == null) {
                            return;

                        } else if (registros.trim().isEmpty()) {

                            JOptionPane.showMessageDialog(frame, "Digite novamente, um erro ocorreu:");
                        } else {

                            validacao = true;

                        }

                    } while (!validacao);

                    JOptionPane.showMessageDialog(frame, "Trabalho Seguro agradece, iremos melhorar no que pudermos, espere uma resposta!");

                } else if (selecao.equals("Registrar Incidente")) {
                    incidentes incidentes = new incidentes();
                    incidentes.registro_Incidente(frame);

                } else if (selecao.equals("Iniciar conversa com gestor de equipe")) {

                    boolean validacao = false;

                    do {

                        String descricao = JOptionPane.showInputDialog(frame, "Digite o que deseja falar com algum gestor:");

                        if (descricao == null) {
                            return;

                        } else if (descricao.trim().isEmpty()) {

                            JOptionPane.showMessageDialog(frame, "Digite novamente, um erro ocorreu:");
                        } else {

                            validacao = true;

                        }

                    } while (!validacao);
                }
            }

        });

        tela.setVisible(true);
    }
}
