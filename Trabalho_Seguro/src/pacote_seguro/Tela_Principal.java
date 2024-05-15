package pacote_seguro;
import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela_Principal {

	public static void main(String[] args) {
		
		funcionario funcionario = new funcionario();
		
		funcionario.interface_funcionario(funcionario);
		
	}

}
