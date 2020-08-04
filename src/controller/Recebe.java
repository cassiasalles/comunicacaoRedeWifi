package controller;

import java.io.*;
import java.net.*;

import model.Informacoes;

public class Recebe implements Runnable{
	
	private volatile boolean exit;
    ServerSocket socket = null;
    Socket conexaoSocket = null;
    ObjectInputStream dadosReceber = null;
    
    private Chat chat;
    private Informacoes info;
    
    private boolean t;
    
    public Recebe(Chat c, Informacoes i) {
		chat = c;
		info = i;
		exit = false;
	}
    
    public void fecharPortaRecebe() throws IOException{
    	exit= true;
    	run();
    }

    public void run() {
        while (!exit) {
            try {
                socket = new ServerSocket(info.getPort());
                t=true;
                while (t == true) {
                	try {
                    	conexaoSocket = socket.accept();
                		dadosReceber = new ObjectInputStream(conexaoSocket.getInputStream());
                		String msg;
    					try {
    						msg = (String) dadosReceber.readObject();
    						chat.recebe(msg);
    					} catch (ClassNotFoundException e) {
    						e.printStackTrace();
    					}
						conexaoSocket.close();
						socket.close();
    				} catch (IOException e) {
    					break;
    				}
                	t=false;
                }
            } catch (IOException e) {
            	exit = true;
				e.printStackTrace();
            }
        }
        try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
