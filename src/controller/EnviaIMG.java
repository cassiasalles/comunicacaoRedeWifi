package controller;

import java.io.*;
import java.net.*;
import org.apache.commons.io.IOUtils;

import model.*;

public class EnviaIMG implements Runnable{

    Informacoes info;
    Socket clientSocket;

    public EnviaIMG(Informacoes info) {
        this.info = info;
    }
    
    public void run() {
        try {
            clientSocket = new Socket(info.getContactIp(), 5085);
            try(
            	InputStream in = new FileInputStream(info.getPathImage());
                OutputStream out = clientSocket.getOutputStream();
            ){
                IOUtils.copy(in, out);
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException ex) {
            System.out.println("Erro ao enviar imagem ! Erro: " + 
            ex.getMessage());
        }
    }   
}
