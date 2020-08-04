package view;

import java.awt.*;
import javax.swing.*;

public class TelaImagem extends JFrame {

    CriaPainel cp;
    
    public TelaImagem(ImageIcon icon){
        desenha(icon);
    }
   
    public void desenha(ImageIcon icon){
    	cp = new CriaPainel(icon);
        criaLayout(cp);
        setTitle("Imagem");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void criaLayout(JComponent... arg) {
        Container container = getContentPane();
        GroupLayout gLayout = new GroupLayout(container);
        container.setLayout(gLayout);
        gLayout.setHorizontalGroup(gLayout.createSequentialGroup().addComponent(arg[0]));
        gLayout.setVerticalGroup(gLayout.createParallelGroup().addComponent(arg[0]));
        pack();
    }
    
    
    class CriaPainel extends JPanel {

    	private ImageIcon icon = null;

    	public CriaPainel(ImageIcon icon) {
            this.icon = icon;
            tamanho();
    	}  
    
        private void tamanho() {
	    int largura = icon.getIconWidth();
	    int altura = icon.getIconHeight();
	    setPreferredSize(new Dimension(largura, altura));
	}    

	@Override
        public void paintComponent(Graphics g) {
	    	super.paintComponent(g);
	    	icon.paintIcon(this, g, 0, 0);
	    }
    }
}
    
    
