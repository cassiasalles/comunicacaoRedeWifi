package controller;

import java.io.IOException;
import java.text.*;
import java.util.*;
import javax.swing.ImageIcon;

import model.*;
import view.*;

public class Chat{
	private Conexao conexao;
	private Informacoes info;
	private TelaChat telaChat;
	private TelaImagem telaImg;
    private TelaConfirmaImagem telaConfirma;
	
    public Chat(TelaChat tChat, Informacoes info) {
        this.info = info;
    	telaChat = tChat;
    }
    
	public void envia(Conexao c) {
		this.conexao = c;
    	DateFormat df = new SimpleDateFormat("hh:mm");
        if (!telaChat.msgField.getText().isEmpty()) {
        	info.setMessage(telaChat.msgField.getText());
            conexao.envia();
            escreve("["+df.format(new Date())+"] Você disse: "+telaChat.msgField.getText());
            telaChat.msgField.setText("");
            telaChat.msgField.requestFocusInWindow();
        }
	}
	
	public void enviaIMG(Conexao c) throws IOException{
        this.conexao = c;
        conexao.enviaIMG();
        DateFormat df = new SimpleDateFormat("hh:mm");
        escreve("["+df.format(new Date())+"] Você enviou uma imagem.");
    }

    public void recebe(String msg) {
		DateFormat df = new SimpleDateFormat("hh:mm");
		escreve("["+df.format(new Date())+"] "+info.getContactName()+" disse: "+msg);
    }
    
    public void recebeIMG(ImageIcon icon){
        DateFormat df = new SimpleDateFormat("hh:mm");
        escreve("["+df.format(new Date())+"] "+info.getContactName()+
                " enviou uma imagem.");
        
        telaConfirma = new TelaConfirmaImagem();
        boolean confirma = false;
        
        if(info.getContactIp() != info.getUserIp()){
            confirma = telaConfirma.confirma(info.getContactName());
        }
        
        if (confirma == true){
            mostraImg(icon);
        }
    }
    
    private void escreve(String texto){
    	telaChat.chatTextArea.append(texto+"\n");
    	if (!telaChat.chatTextArea.getText().isEmpty() && !telaChat.chatTextArea.isFocusOwner()) {
    		telaChat.chatTextArea.setCaretPosition(telaChat.chatTextArea.getText().length() - 1);
    	}  
    }
    
    public void mostraImg(ImageIcon icon) {
        telaImg = new TelaImagem(icon);
        telaImg.setVisible(true);
    }
}