package controller;

import java.awt.event.*;
import java.io.IOException;

import view.*;
import model.*;

public class ControllerPrincipal {

	public Informacoes info;
	public TelaLogin telaLogin;
	public TelaChat telaChat;
	public TelaNovaConversa telaNovaConversa;
	private Conexao conexao;
	private Chat chat;
	private NovaConversa novaConversa;
	private TelaJFile telaJFile;
	
	public ControllerPrincipal(Informacoes info, Conexao c, TelaLogin tLogin, TelaNovaConversa tConversa, TelaChat tChat, TelaJFile tJFile, Chat chat, NovaConversa novaConversa) throws ClassNotFoundException {
		this.conexao = c;
		this.chat = chat;
		this.info = info;
		this.novaConversa = novaConversa;
		
		telaLogin = tLogin;
		telaNovaConversa = tConversa;		
		telaChat = tChat;
		telaJFile = tJFile;
		
		telaChat.addSendMessageListener(new Enviar());
		telaChat.addBackListener(new Voltar());
		telaChat.addIMGListener(new EnviarImg());
		telaNovaConversa.addNewChatListener(new Conversar());
		telaNovaConversa.addSignOutListener(new Sair());
		telaLogin.addsignInListener(new Entrar());
	}
	
	class Entrar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean l = conexao.login();
			if(l == true){
				telaNovaConversa.userNameLabel.setText(info.getUserName());
				telaNovaConversa.userIpLabel.setText(info.getUserIp());
				telaLogin.dispose();
				telaNovaConversa.setVisible(true);		
			}
		}
	}
	
	class Conversar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				String ipContato = telaNovaConversa.ipChatField.getText();
				boolean c = novaConversa.contatoConversa(ipContato);
				if(c == true) {
					telaChat.friendChating.setText(info.getContactName());
					telaNovaConversa.dispose();
					telaNovaConversa.ipChatField.setText("");
					telaChat.setVisible(true);
		            telaChat.msgField.requestFocusInWindow();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class Enviar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	    	chat.envia(conexao);
		}
	}
	
	class EnviarImg implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try{
                String path = "";
                path = telaJFile.caminho();
                info.setPathImage(path);                  
                chat.enviaIMG(conexao);
            }catch(IOException ex){
                System.out.println("Erro IO");
            }
        }
    }
	
	class Voltar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				conexao.fecharPorta();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			telaChat.chatTextArea.setText("");
			telaChat.dispose();
			telaNovaConversa.setVisible(true);
		}
	}
	
	class Sair implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			telaNovaConversa.dispose();
            System.exit(0);
		}
	}
}
