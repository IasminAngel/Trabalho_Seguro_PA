package pacote_seguro;

import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class funcionario {
    public void interface_funcionario (funcionario funcionario) {

    	gestor_Equipe gestao = new gestor_Equipe();
    	
        JFrame frame = new JFrame ("Bem-vindos ao Trabalho Seguro"); 
        frame.setSize(1200,500); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        JButton button = new JButton ("''Trabalho Seguro'' sempre com você, pela sua segurança. Para prosseguirmos e auxiliar nos problemas empresariais, nos informe, é Funcionário ou Gestor de Equipe ?");
        
        button.addActionListener(new ActionListener() {
        	
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
                
                if (escolha == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Você selecionou Funcionário");
                    
                 // Aplicar abretura do site d elogin do trabalho seguro
                } else if (escolha == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Você selecionou Gestor de Equipe");
                    
                    // Aplicar abretura do site d elogin do trabalho seguro
                }
                
                gestao.opcoes_Gestor_Equipe(escolha, frame);
               
            	   
               }
            });
        
       
        frame.getContentPane().add(button);
        
        frame.setVisible(true); 
    }
}
