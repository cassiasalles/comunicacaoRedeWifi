package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JLabel GroupNameLabel;
	private JLabel welcomeLabel;
	private JLabel username;
	private JLabel ipAddress;
	private JLabel port;
	private JButton signInButton;

	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		GroupNameLabel = new JLabel("Chat Grupo 3");
		GroupNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GroupNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupNameLabel.setBounds(122, 11, 190, 27);
		contentPane.add(GroupNameLabel);
		
		welcomeLabel = new JLabel("Bem vindo!");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(122, 72, 181, 37);
		contentPane.add(welcomeLabel);
		
		username = new JLabel("");
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setBounds(189, 72, 153, 20);
		contentPane.add(username);
		
		ipAddress = new JLabel("");
		ipAddress.setHorizontalAlignment(SwingConstants.LEFT);
		ipAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ipAddress.setBounds(56, 141, 153, 16);
		contentPane.add(ipAddress);
		
		port = new JLabel("");
		port.setFont(new Font("Tahoma", Font.PLAIN, 14));
		port.setHorizontalAlignment(SwingConstants.LEFT);
		port.setBounds(76, 170, 153, 16);
		contentPane.add(port);
		
		signInButton = new JButton("Entrar");
		signInButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		signInButton.setBounds(153, 197, 111, 43);
		contentPane.add(signInButton);
	}
	
	public void addsignInListener(ActionListener signIn) {
		signInButton.addActionListener(signIn);
	}
}
