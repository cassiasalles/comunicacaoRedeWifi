package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaConfirmaImagem extends JFrame{
    
    public boolean confirma(String usuario){
    	Object[] opcoes = { "Sim", "Não" };
        int resposta =  JOptionPane.showOptionDialog(this,usuario+" enviou uma imagem. Deseja abrir?", "Imagem de " +usuario, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (resposta == JOptionPane.YES_OPTION){
            return true;
        }
        else{
            return false;
        }
    }
}
