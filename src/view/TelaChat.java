package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class TelaChat extends JFrame {

	private JPanel contentPane;
	private JLabel chatingWithLabel;
	public JLabel friendChating;
	private JButton backButton;
	public JTextField msgField;
	public JTextArea chatTextArea;
	private JButton sendMesageButton;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton sendIMGButton;

	public TelaChat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chatingWithLabel = new JLabel("Conversando com:");
		chatingWithLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chatingWithLabel.setBounds(23, 13, 118, 16);
		contentPane.add(chatingWithLabel);
		
		friendChating = new JLabel("");
		friendChating.setFont(new Font("Tahoma", Font.BOLD, 14));
		friendChating.setBounds(145, 14, 191, 15);
		contentPane.add(friendChating);
		
		backButton = new JButton("Voltar");
		backButton.setBounds(501, 26, 76, 25);
		contentPane.add(backButton);
		
		chatTextArea = new JTextArea();
		chatTextArea.setBounds(12, 75, 579, 249);
		contentPane.add(chatTextArea);
		
		msgField = new JTextField();
		msgField.setToolTipText("");
		msgField.setBounds(23, 348, 475, 43);
		contentPane.add(msgField);
		msgField.setColumns(10);
		
		sendIMGButton = new JButton("IMG");
        sendIMGButton.setBounds(515, 342, 76, 25);
        contentPane.add(sendIMGButton);
		
		sendMesageButton = new JButton("Enviar");
		sendMesageButton.setBounds(515, 368, 76, 25);
		contentPane.add(sendMesageButton);
		
		separator = new JSeparator();
		separator.setBounds(12, 62, 579, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(12, 335, 579, 2);
		contentPane.add(separator_1);
	}
	
	public void addSendMessageListener(ActionListener send) {
		sendMesageButton.addActionListener(send);
	}
	
	public void addBackListener(ActionListener back) {
		backButton.addActionListener(back);
	}
	
	public void addIMGListener(ActionListener send) {
		sendIMGButton.addActionListener(send);
	}
}
