package view;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TelaJFile extends JFrame{
    
    private JFileChooser fileChooser;
    
    public TelaJFile() {
        fileChooser = new JFileChooser();
    }
    
    public String caminho(){
        String caminho = "vazio";
        
        fileChooser.setDialogTitle("Selecionar imagem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagem", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filtro);
        
        if(fileChooser.showDialog(this, "Abrir") == JFileChooser.APPROVE_OPTION)
        {
        	caminho = fileChooser.getSelectedFile().getAbsolutePath();
        }
     
        return caminho;
    }  
}
