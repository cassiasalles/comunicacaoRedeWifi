package controller;

import java.io.IOException;
import java.net.InetAddress;
import javax.swing.JOptionPane;

import model.*;

public class NovaConversa {

	private Informacoes info;
	private Conexao conexao;
	

	public NovaConversa(Informacoes info, Conexao c) {
		this.info = info;
		conexao = c;
	}

	public boolean contatoConversa(String ipContato) throws IOException {
		int timeout = 1000;
		InetAddress inetAddr = InetAddress.getByName(ipContato);
		String hostname = inetAddr.getHostName();
		if (InetAddress.getByName(ipContato).isReachable(timeout)) {
			info.setContactIp(ipContato);
			info.setContactName(hostname);
			conexao.recebe();
			conexao.recebeImg();
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Este endereço de IP não está disponível.\nPor favor, digite outro.", "Endereço IP não encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
}
