package pacote_seguro;

import javax.swing.*;
import java.awt.Component;

public class epis {
    
    gestor_Equipe gestor_Equipe = new gestor_Equipe(); 
    
    public void EPIS(Component frame) {
        Object[] epis = {"Verificar EPIS", "Outra Opção"};
        int escolhaEPI = JOptionPane.showOptionDialog(frame, "Selecione uma opção:", "Escolha",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, epis, epis[0]);

        if (escolhaEPI == JOptionPane.YES_OPTION) {
            verificacao_Epis(frame);
        } else if (escolhaEPI == JOptionPane.NO_OPTION) {
            gestor_Equipe.finalizacao(frame);
        }
    }

    //------------------------------------------------------------
    public void verificacao_Epis(Component frame){
        
        Object[] epis = {"Sim", "Não"};
        int escolhaEPI = JOptionPane.showOptionDialog(frame, "Os EPIS foram distruibidos para todas as alas?", "Escolha",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, epis, epis[0]);

        if (escolhaEPI == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(frame, "Ótimo! Para reposição, comunique aos superiores, ou abra um chamado no fórum! Trabalho Seguro sempre com você =)");
        } else if (escolhaEPI == JOptionPane.NO_OPTION) {
            boolean validacao = false;

            do {
                String chamado = JOptionPane.showInputDialog(frame, "Qual(s) ala(s) que não houve reposição de EPIS?"); 
                if (chamado == null) {
                    return; 
                } else if (chamado.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Digite novamente, um erro ocorreu:");
                } else {
                    validacao = true; 
                }
            } while (!validacao);

            JOptionPane.showMessageDialog(frame, "Ótimo! Trabalharemos nesse defeito, comunique aos superiores, ou abra um chamado no fórum! Trabalho Seguro sempre com você =)");
        }
    }
}
