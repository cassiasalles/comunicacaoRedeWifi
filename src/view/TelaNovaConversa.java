package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class TelaNovaConversa extends JFrame {
	
	private JPanel contentPane;
	public JLabel userNameLabel;
	private JButton signOutButton;
	private JLabel newChatLabel;
	public JTextField ipChatField;
	private JLabel ipChatLabel;
	private JButton newChatButton;
	private JLabel ipLabel;
	public JLabel userIpLabel;

	public TelaNovaConversa(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userNameLabel = new JLabel("Usu\u00E1rio:");
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel.setBounds(12, 13, 56, 16);
		contentPane.add(userNameLabel);
		
		userNameLabel = new JLabel();
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel.setBounds(68, 13, 244, 16);
		contentPane.add(userNameLabel);
		
		signOutButton = new JButton("Sair");
		signOutButton.setBounds(407, 11, 67, 25);
		contentPane.add(signOutButton);
		
		newChatLabel = new JLabel("Iniciar nova conversa:");
		newChatLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		newChatLabel.setBounds(12, 70, 244, 25);
		contentPane.add(newChatLabel);
		
		ipChatLabel = new JLabel("Digite o IP:");
		ipChatLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ipChatLabel.setBounds(22, 133, 74, 14);
		contentPane.add(ipChatLabel);
		
		ipChatField = new JTextField();
		ipChatField.setBounds(89, 131, 107, 20);
		contentPane.add(ipChatField);
		ipChatField.setColumns(10);
		
		newChatButton = new JButton("Conversar");
		newChatButton.setBounds(226, 130, 119, 23);
		contentPane.add(newChatButton);
		
		ipLabel = new JLabel("IP:");
		ipLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ipLabel.setBounds(12, 40, 27, 14);
		contentPane.add(ipLabel);
		
		userIpLabel = new JLabel();
		userIpLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userIpLabel.setBounds(33, 40, 107, 14);
		contentPane.add(userIpLabel);
	}
	
	public void addNewChatListener(ActionListener newChat) {
		newChatButton.addActionListener(newChat);
	}
	
	public void addSignOutListener(ActionListener signOut) {
		signOutButton.addActionListener(signOut);
	}
}
