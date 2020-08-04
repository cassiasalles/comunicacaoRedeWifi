package controller;

import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class RecebeIMG implements Runnable{
    
    private boolean erro = false;
    ServerSocket socket = null;
    Socket conexaoSocket;
    ImageIcon icon;
    private boolean exit;
    
    private Chat chat;
   
    public RecebeIMG(Chat c) {
        this.chat = c;
        exit = false;
    }
    
    public void fecharPortaRecebeImg() throws IOException{
        exit= true;
        run();
    }
   
    public void run(){
    	while(!exit){
    		try {
    			socket = new ServerSocket(5085);
    			while(!erro){
    				try{
    					conexaoSocket = socket.accept();
                    	InputStream in = conexaoSocket.getInputStream();
                        BufferedImage img=ImageIO.read(ImageIO.createImageInputStream(in));
                        
                        if(img != null){
                        	icon = new ImageIcon(img);
                            chat.recebeIMG(icon);
                        }
                        in.close();
                        break;
                    }catch (IOException e){
                    	break;
                    }
                }
                conexaoSocket.close();
                socket.close();
                erro = false;
            }catch (IOException ex) {
            	System.out.println("Erro IO RecebIMG: " + ex.getMessage());
            }catch(NullPointerException e){
            	break;
            }   
        }
        try {
            socket.close();
        }catch (IOException e) {
        	e.printStackTrace();
        }
    }
}