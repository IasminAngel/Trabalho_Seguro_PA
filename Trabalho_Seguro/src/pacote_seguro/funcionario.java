package pacote_seguro;

import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class funcionario {
    public void interface_funcionario (funcionario funcionario) {

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
                } else if (escolha == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Você selecionou Gestor de Equipe");
                }
  
                
               if(escolha == JOptionPane.NO_OPTION) {
            	   Object[] escolhaGestor = {"Verificar perfil", "Outra opção"};
            	   int escolha1 = JOptionPane.showOptionDialog(frame,
                           "Selecione uma opção:",
                           "Escolha",
                           JOptionPane.YES_NO_OPTION,
                           JOptionPane.QUESTION_MESSAGE,
                           null,
                           escolhaGestor,
                           escolhaGestor[0]);
            	   
            	   if(escolha1== JOptionPane.YES_OPTION) { 
            		   JOptionPane.showInputDialog("Verificando perfil..."); 
            		   
            		   } else if (escolha1 == JOptionPane.NO_OPTION){
            			   JOptionPane.showInputDialog("AAAAAAAA");
            		   } 
            	   }
            	  
            	   
                 // JOptionPane.showConfirmDialog(null, "Deseja verificar o perfil de algum funcionário registrado ?");
            	   
               }
            });
        
        //  Adiciona o botão a janela
        frame.getContentPane().add(button);
        
        // Exibir a janela
        frame.setVisible(true); 
    }
}
