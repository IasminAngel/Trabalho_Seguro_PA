package pacote_seguro;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class incidentes {
	void registro_Incidente (Component frame) {
	
        boolean validacao = false;

        do {	
        	String data = JOptionPane.showInputDialog(frame, "Digite a data do ocorrido do incidente:");
            if (data == null) {
                return; 
            } else if (data.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Digite novamente, um erro ocorreu:");
            } else {
                validacao = true; 
            }
            
        } while (!validacao);
                
        do {	
        	String tipo = JOptionPane.showInputDialog(frame, "Digite o tipo de incidente:");
            if (tipo == null) {
                return; 
            } else if (tipo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Digite novamente, um erro ocorreu:");
            } else {
                validacao = true; 
            }
            
        } while (!validacao);
        
        do {
        	String descricao = JOptionPane.showInputDialog(frame, "Digite uma descrição detalhada do incidente:");
            if (descricao == null) {
                return; 
            } else if (descricao.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Digite novamente, um erro ocorreu:");
            } else {
                validacao = true; 
            }
            
        } while (!validacao);
            
            Object[] confirmacao = {"Sim", "Nao"};
            int afetado = JOptionPane.showOptionDialog(frame, "Algum funcionário foi afetado ?", "Escolha",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, confirmacao, confirmacao[0]);

            if (afetado == JOptionPane.YES_OPTION) {
            	JOptionPane.showInputDialog(frame, "Digite a matrícula do funcionário afetado:");
            	// incrementar if se a matricula for igual a de um funcionario comum
            	Object[] confirmacao2 = {"Sim", "Nao"};
                int afetado2 = JOptionPane.showOptionDialog(frame, "Ele estava utilizando EPI ?", "Escolha",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, confirmacao2, confirmacao2[0]);

                if (afetado2 == JOptionPane.YES_OPTION) {
                	JOptionPane.showInputDialog(frame, "Qual o nome da EPI que estava utilizando ?");
                	// registrar nome do EPI
                	
                } else if (afetado2 == JOptionPane.NO_OPTION) {
                	JOptionPane.showMessageDialog(frame, "Registro concluído =D");
                }
             	
            } else if (afetado == JOptionPane.NO_OPTION) {
            		JOptionPane.showMessageDialog(frame, "Registro concluído =D");
            }
           	
	}
}
