package pacote_seguro;

import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class funcionario {
    public void interface_funcionario (funcionario funcionario) {
        
        // Declaracao do gestor de equipe, outra subclasse, coloquei para reduzir o tamanho do codigo e nao interferir com a parte do funcionario em si que sera feito
    	gestor_Equipe gestao = new gestor_Equipe();

    	// Apresentacao
        JFrame frame = new JFrame ("Bem-vindos ao Trabalho Seguro"); 
        frame.setSize(1200,500); // determinando tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        // Botao pressionado quando abre a janela acima
        JButton button = new JButton ("''Trabalho Seguro'' sempre com você, pela sua segurança. Para prosseguirmos e auxiliar nos problemas empresariais, nos informe, é Funcionário ou Gestor de Equipe ?");
        
        button.addActionListener(new ActionListener() {

            // Determinando as opcoes de acordo com as selecoes abaixo, qual seria funcionario e gestor de equipe
            public void actionPerformed(ActionEvent e){
                Object[] options = {"Funcionário", "Gestor de Equipe"};
                int escolha = JOptionPane.showOptionDialog(frame,
                        "Selecione uma opção:",
                        "Escolha",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                // O if determina o que ocorrera quando apertar cada botao, pois o botoa originalmente e sim e nao, mas modifico o nome e determino o que vai ocorrer
                if (escolha == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Você selecionou Funcionário");
                    
                 // Aplicar abretura do site de login do trabalho seguro (NETBEANS) 
                } else if (escolha == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Você selecionou Gestor de Equipe");
                    
                    // Aplicar abretura do site de login do trabalho seguro (NETBEANS)
                }

                // Continuacao do codigo a partir da outra subclasse
                gestao.opcoes_Gestor_Equipe(escolha, frame);
               
            	   
               }
            });
        
       
        frame.getContentPane().add(button);
        
        frame.setVisible(true); 
    }
}
