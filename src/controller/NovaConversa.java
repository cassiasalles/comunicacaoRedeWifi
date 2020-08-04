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
			JOptionPane.showMessageDialog(null, "Este endere�o de IP n�o est� dispon�vel.\nPor favor, digite outro.", "Endere�o IP n�o encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
}
