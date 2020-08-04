package controller;

import java.io.IOException;
import java.net.*;

import model.*;

public class Conexao {

	private InetAddress address;
    private Informacoes info;
    private Chat chat;
    private Recebe r;
    private Envia e;
    private EnviaIMG eImg;
    private RecebeIMG rImg;
    
    private String userIp;
    private String userName;
    public String msg;

	public Conexao(Informacoes i, Chat c) {
		this.info = i;
		this.chat = c;
		e = new Envia(info);
        eImg = new EnviaIMG(info);
	}
	
	public boolean login() {
		try {
			address = InetAddress.getLocalHost(); 
		    userIp = address.getHostAddress() ;
		    userName = address.getHostName();
		    
            info.setUserIp(userIp);
            info.setUserName(userName);
            info.setPort(5000);
            
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public void envia() {
		new Thread(e).start();
	}
	
	public void enviaIMG() {
		new Thread(eImg).start();
	}
	
	public void recebe() {
		r = new Recebe(chat, info);
		new Thread(r).start();
	}
	
	public void recebeImg(){
        rImg = new RecebeIMG(chat);
        new Thread(rImg).start();
    }
	
	public void fecharPorta() throws IOException {
		r.fecharPortaRecebe();
		rImg.fecharPortaRecebeImg();
	}
}
