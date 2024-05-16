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
		
	// Recomendo que executem o codigo, lembrem de converter para Maven! 			
	// Daqui pra frente segue o mesmo esquema que o outro, as diferencas eu aplico aqui
		
		
		if(escolha == JOptionPane.NO_OPTION) {
			
			// Verificação de perfil, dando opções: 
      	   Object[] escolhaGestor1 = {"Verificar perfil", "Outra opção"};
      	   int escolha1 = JOptionPane.showOptionDialog(frame,
                     "Selecione uma opção:",
                     "Escolha",
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE,
                     null,
                     escolhaGestor1,
                     escolhaGestor1[0]);
      	   
      	   // Escolha Sim: Verificação de perfil
      	   if(escolha1== JOptionPane.YES_OPTION) { 
      		   JOptionPane.showInputDialog("Verificando perfil: Digite a matrícula do funcionário"); 
      		   
      		   // Criar um comando que interliga o subclasse funcionário para cá com as informações dele
      		   
      		// Escolha Não: Verificação de perfil
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
      			   
      			  
      			   // Informe Incidente, dando opções: 
      			  if(escolha2 == JOptionPane.YES_OPTION) {
      				JOptionPane.showMessageDialog(frame,"Informe o Incidente");
      				
      				// Fazer uma sublcasse incidente e aplicar
				  
      				// nesse codigo abaixo por inteiro, faz a janela de selecao de informacoes na caixa de mensagem, tem as determinacoes de tamanho dado em aula
      				JFrame local = new JFrame ("Incidente:");
  					local.setSize(400,300);
  					local.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  					local.setLayout(null);
  					
  					// Sequencial de pergunta para listagem do incidente
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
  					
  					JButton button = new JButton ("Enviar Incidente");
  					button.setBounds(150,220,100,30);
  					
  					button.addActionListener(new ActionListener() {
  						public void actionPerformed (ActionEvent e) {
  							
  							String textoDigitado = textField.getText();
  							textArea.append(textoDigitado + "\n");
  							textField.setText("");
  							
  							// Comando para o segundo click fechar a janela
  							button.addActionListener(new ActionListener() {
  							    public void actionPerformed(ActionEvent e) {
  							        String textoDigitado = textField.getText();
  							        textArea.append(textoDigitado + "\n");
  							        textField.setText("");
  							        local.dispose(); 
  							    }
  							});
  						}
  					});
  					
  					local.add(button); 
  					
  					local.setVisible(true);
      				
  					// Observação para algum funcinário, dando poções:
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
      				  
      				  // Escolha Sim: Observação funcionário
      				  if(escolha3 == JOptionPane.YES_OPTION) {
      					JOptionPane.showMessageDialog(frame,"Digite em poucas palavras uma observação para o usuário:");
      					  
      					JFrame local = new JFrame ("Status usuário:");
      					local.setSize(400,300); 
      					local.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      					local.setLayout(null); 
      				
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
      					  
      					// Status do funcionário, dando as opções: 
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
        				  
        				  
        				  // Escolha Sim: Definição de status de funcionário
        				  if(escolha4 == JOptionPane.YES_OPTION) {
        					  JOptionPane.showInputDialog("Digite o estado do atual funcionário, de acordo com as opções seguintes:");
        					  
        				  // Escolha Não: Definição de status de funcionário
        				  } else if(escolha4 == JOptionPane.NO_OPTION) {
        					  JOptionPane.showMessageDialog(frame, "Não há mais opções, caso queira recomeçar, apenas dê um clique! Obrigado por acessar Trabalho Seguro =) !");
        				  }
      				  }
      			  }
      		   
      		   } 
      	   }
	}
	

}
