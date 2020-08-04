package controller;

import java.io.*;
import java.net.*;

import model.*;

public class Envia implements Runnable {
	
	Informacoes info;
	String message;
	Conexao c;
	
	Socket clientSocket=null;
	ObjectOutputStream dadosEnviar=null;
	
	public Envia(Informacoes info) {
		this.info = info;
	}

	public void run() {
		message = info.getMessage();
		try {
			clientSocket = new Socket(info.getContactIp(), info.getPort());
			dadosEnviar = new ObjectOutputStream(clientSocket.getOutputStream());
			dadosEnviar.writeObject(message);
			dadosEnviar.close();
			clientSocket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
