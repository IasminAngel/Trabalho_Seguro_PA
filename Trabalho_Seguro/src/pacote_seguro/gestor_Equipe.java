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

public class gestor_Equipe {
	public void opcoes_Gestor_Equipe (int escolha, Component frame) {
				
		if(escolha == JOptionPane.NO_OPTION) {
      	   Object[] escolhaGestor1 = {"Verificar perfil", "Outra opção"};
      	   int escolha1 = JOptionPane.showOptionDialog(frame,
                     "Selecione uma opção:",
                     "Escolha",
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE,
                     null,
                     escolhaGestor1,
                     escolhaGestor1[0]);
      	   
      	   if(escolha1== JOptionPane.YES_OPTION) { 
      		   JOptionPane.showInputDialog("Verificando perfil: Digite a matrícula do funcionário"); 
      		   
      		   } else if (escolha1 == JOptionPane.NO_OPTION){
      			   Object[] escolhaGestor2 = {"Informar Incidente", "Outra opção"};
      			   int escolha2 = JOptionPane.showOptionDialog(frame,
      					   "Selecione uma opção:",
      					   "Escolha",
      					   JOptionPane.YES_NO_OPTION,
      					   JOptionPane.QUESTION_MESSAGE,
      					   null,
      					   escolhaGestor2,
      					   escolhaGestor2[0]);
      			   
      			  if(escolha2 == JOptionPane.YES_OPTION) {
      				JOptionPane.showMessageDialog(frame,"Informe o Incidente");
      				
      				JFrame local = new JFrame ("Incidente:");
  					local.setSize(400,300); // Definir o tamanho da janela
  					local.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fechar quando a janela for fechada
  					local.setLayout(null); // Definir layout como nulo
  				
  					JLabel label = new JLabel("Digite o incidente com os requisitos:");
  					JOptionPane.showMessageDialog(frame,"1º Incidente Detalhado | 2º Ala Afetada | 3º Nível de perigo (Baixo, Médio, Grave)");
  					JOptionPane.showMessageDialog(frame,"Observação: Após o segundo clique, sua informação será mandado para o nosso sistema!"); // listar como erro
  					
  					label.setBounds(20,20,100,20); 
  					local.add(label);
  					
  					JTextField textField = new JTextField();
  					textField.setBounds(120,20,200,20);
  					local.add(textField); 
  					
  					JTextArea textArea = new JTextArea();
  					textArea.setBounds(20,50,300,150);
  					local.add(textArea);
  					
  					JButton button = new JButton ("Clique aqui");
  					button.setBounds(150,220,100,30);
  					
  					button.addActionListener(new ActionListener() {
  						public void actionPerformed (ActionEvent e) {
  							
  							String textoDigitado = textField.getText();
  							textArea.append(textoDigitado + "\n");
  							textField.setText("");
  							
  							button.addActionListener(new ActionListener() {
  							    public void actionPerformed(ActionEvent e) {
  							        String textoDigitado = textField.getText();
  							        textArea.append(textoDigitado + "\n");
  							        textField.setText("");
  							        local.dispose(); // Fechar a janela após o clique no botão
  							    }
  							});

  						}
  					});
  					
  					local.add(button); 
  					
  					local.setVisible(true);
      				
      			  } else if (escolha2 == JOptionPane.NO_OPTION) {
      				  Object[] escolhaGestor3 = {"Observação para algum funcionário", "Outra opção"}; 
      				  int escolha3 = JOptionPane.showOptionDialog(frame,
      						  "Selecione uma opção",
      						  "Escolha",
      						  JOptionPane.YES_NO_OPTION,
       					      JOptionPane.QUESTION_MESSAGE,
       					   	  null,
      						  escolhaGestor3,
      						  escolhaGestor3[0]);
      				  
      				  if(escolha3 == JOptionPane.YES_OPTION) {
      					JOptionPane.showMessageDialog(frame,"Digite em poucas palavras uma observação para o usuário:");
      					  
      					JFrame local = new JFrame ("Status usuário:");
      					local.setSize(400,300); // Definir o tamanho da janela
      					local.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fechar quando a janela for fechada
      					local.setLayout(null); // Definir layout como nulo
      				
      					JLabel label = new JLabel("Digite o status com os requisitos:");
      					JOptionPane.showMessageDialog(frame,"1º Nome do funcionário | 2º Status na ala (Regular, Irregular ou Troca de Ala )");
      					JOptionPane.showMessageDialog(frame,"Observação: Após o segundo clique, sua informação será mandado para o nosso sistema!"); // listar como erro
      					
      					label.setBounds(20,20,100,20); 
      					local.add(label);
      					
      					JTextField textField = new JTextField();
      					textField.setBounds(120,20,200,20);
      					local.add(textField); 
      					
      					JTextArea textArea = new JTextArea();
      					textArea.setBounds(20,50,300,150);
      					local.add(textArea);
      					
      					JButton button = new JButton ("Clique aqui");
      					button.setBounds(150,220,100,30);
      					
      					button.addActionListener(new ActionListener() {
      						public void actionPerformed (ActionEvent e) {
      							
      							String textoDigitado = textField.getText();
      							textArea.append(textoDigitado + "\n");
      							textField.setText("");
      						
      							
      							button.addActionListener(new ActionListener() {
      							    public void actionPerformed(ActionEvent e) {
      							        String textoDigitado = textField.getText();
      							        textArea.append(textoDigitado + "\n");
      							        textField.setText("");
      							        local.dispose(); // Fechar a janela após o clique no botão
      							        
      							      
      							    }
      							   
      							});
      							
      						}
      					});
      					
      					local.add(button); 
      					
      					local.setVisible(true);
      					  
      				  } else if (escolha3== JOptionPane.NO_OPTION) {
      					Object[] escolhaGestor4 = {"Definir Status de algum funcionário", "Outra opção"}; 
        				  int escolha4 = JOptionPane.showOptionDialog(frame,
        						  "Selecione uma opção",
        						  "Escolha",
        						  JOptionPane.YES_NO_OPTION,
         					      JOptionPane.QUESTION_MESSAGE,
         					   	  null,
        						  escolhaGestor4,
        						  escolhaGestor4[0]); 
        				  if(escolha4 == JOptionPane.YES_OPTION) {
        					  JOptionPane.showInputDialog("Digite o estado do atual funcionário, de acordo com as opções seguintes:");
        				  } else if(escolha4 == JOptionPane.NO_OPTION) {
        					  JOptionPane.showMessageDialog(frame, "Não há mais opções, caso queira recomeçar, apenas dê um clique! Obrigado por acessar Trabalho Seguro =) !");
        				  }
      				  }
      			  }
      		   
      		   } 
      	   }
	}
	

}
