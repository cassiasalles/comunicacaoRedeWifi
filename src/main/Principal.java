package main;

import java.io.IOException;

import view.*;
import controller.*;
import model.*;

public class Principal {
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		Informacoes info = new Informacoes();
		TelaLogin telaLogin = new TelaLogin();
		TelaChat telaChat = new TelaChat();
		TelaNovaConversa telaNovaConversa = new TelaNovaConversa();
		TelaJFile telaJFile = new TelaJFile();
        Chat chat = new Chat(telaChat, info);
		Conexao conexao = new Conexao(info, chat);
		NovaConversa novaConversa = new NovaConversa(info, conexao);
		ControllerPrincipal cp = new ControllerPrincipal(info, conexao, telaLogin, telaNovaConversa, telaChat, telaJFile, chat, novaConversa);
		telaLogin.setVisible(true);
	}
}
