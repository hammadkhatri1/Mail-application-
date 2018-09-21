/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silabs.mail.mail;

/**
 *
 * @author hammad
 */

import com.silabs.mail.accounts.ViewAccount;
import com.silabs.mail.main.MainApplication;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;


import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Font;

public class GenerateMail extends JFrame {

	JPanel contentPane;
	JTextField senderId;
	JPasswordField senderpassword;

	JTextField host;
	JTextField port;
	JTextField reciever;
	JTextField subject;
	JTextArea message;

	public GenerateMail(String temp) throws IOException {
		initComponents(temp);
		CenteredFrame(this);

		}

		public void CenteredFrame(javax.swing.JFrame objFrame) {
			Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
			int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
			int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
			objFrame.setLocation(iCoordX, iCoordY);
		}
		public void initComponents(String temp) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("MAIL FORM");
		
		
		JLabel lblWriteMail = new JLabel("WRITE MAIL");
		lblWriteMail.setFont(new Font("Dialog", Font.BOLD, 15));
		lblWriteMail.setBounds(293, 12, 119, 15);
		contentPane.add(lblWriteMail);

		JLabel lblSenderId = new JLabel("Sender id:");
		lblSenderId.setBounds(12, 139, 100, 15);
		contentPane.add(lblSenderId);

		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(12, 166, 100, 15);
		contentPane.add(lblPassword);

		JLabel lblHost = new JLabel("host:");
		lblHost.setBounds(12, 193, 70, 15);
		contentPane.add(lblHost);

		JLabel lblPort = new JLabel("port:");
		lblPort.setBounds(12, 220, 70, 15);
		contentPane.add(lblPort);

		JLabel lblReciever = new JLabel("Reciever:");
		lblReciever.setBounds(12, 281, 70, 15);
		contentPane.add(lblReciever);

		JLabel lblSubject = new JLabel("subject:");
		lblSubject.setBounds(12, 326, 70, 15);
		contentPane.add(lblSubject);

		JLabel lblMessages = new JLabel("Messages:");
		lblMessages.setBounds(12, 360, 100, 15);
		contentPane.add(lblMessages);

		message = new JTextArea();

		JScrollPane sc = new JScrollPane(message);
		sc.setBounds(111, 360, 551, 294);
		contentPane.add(sc);
		//
		message.setText(temp);

		JButton btnBackcancel = new JButton("BACK");
		btnBackcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainApplication ma = new MainApplication();
				ma.setVisible(true);
				dispose();
			}
		});
		btnBackcancel.setBounds(12, 666, 117, 25);
		contentPane.add(btnBackcancel);

		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					SenderDetails sd = new SenderDetails();

					sd.setSenderId(senderId.getText());
					sd.setSenderpassword(senderpassword.getText());
					sd.setBody(message.getText());
					sd.setHost(host.getText());
					sd.setPort(port.getText());
					sd.setReciever(reciever.getText());
					sd.setSubject(subject.getText());

					SendMail se = new SendMail(sd);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSend.setBounds(545, 666, 117, 25);
		contentPane.add(btnSend);

		senderId = new JTextField();
		senderId.setBounds(111, 137, 233, 19);
		contentPane.add(senderId);
		senderId.setColumns(10);

		senderpassword = new JPasswordField();
		senderpassword.setBounds(111, 166, 233, 19);
		contentPane.add(senderpassword);

		host = new JTextField();
		host.setBounds(111, 193, 196, 19);
		contentPane.add(host);
		host.setColumns(10);

		port = new JTextField();
		port.setBounds(111, 218, 196, 19);
		contentPane.add(port);
		port.setColumns(10);

		reciever = new JTextField();
		reciever.setBounds(111, 279, 344, 19);
		contentPane.add(reciever);
		reciever.setColumns(10);

		subject = new JTextField();
		subject.setBounds(111, 324, 344, 19);
		contentPane.add(subject);
		subject.setColumns(10);

		JButton btnViewAccounts = new JButton("View Accounts");
		btnViewAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewAccount va = new ViewAccount();
				va.setVisible(true);
			}
		});
		btnViewAccounts.setBounds(518, 242, 144, 25);
		contentPane.add(btnViewAccounts);

		JButton gmailbutton = new JButton();
		gmailbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setGmailValues();
			}

		});

		ImageIcon ic = new ImageIcon();
		gmailbutton.setIcon(new ImageIcon("src/resources/images/gmail2.jpg"));
		gmailbutton.setBounds(524, 121, 52, 33);
		contentPane.add(gmailbutton);

		JButton hotmailbutton = new JButton();
		hotmailbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHotmailValues();
			}

		});
		hotmailbutton.setIcon(new ImageIcon("src/resources/images/hotmail.jpg"));
		hotmailbutton.setBounds(524, 175, 52, 33);
		contentPane.add(hotmailbutton);

		JButton btnNewButton = new JButton("Choose a file");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFileName();

			}
		});
		btnNewButton.setBounds(518, 300, 144, 25);
		contentPane.add(btnNewButton);
		
		/////////////////////////////
		
		ImageIcon background = new ImageIcon("src/resources/images/suffaLogo.jpg");
		JLabel label = new JLabel();
		label.setBounds(211, 39, 80, 80);
		label.setIcon(background);
		contentPane.add(label);
		
		ImageIcon background1 = new ImageIcon("src/resources/images/silabs.jpg");
		JLabel label1 = new JLabel();
		label1.setBounds(332, 39, 80, 80);
		label1.setIcon(background1);
		contentPane.add(label1);
		
	}

	private void setGmailValues() {
		host.setText("smtp.gmail.com");
		port.setText("587");
	}

	private void setHotmailValues() {
		host.setText("smtp.live.com");
		port.setText("587");
	}

	public void getFileName() {
		String fileName = null;
		JFileChooser jFileChooser = new JFileChooser();

		jFileChooser.setCurrentDirectory(new File("src/resources/"));

		int result = jFileChooser.showOpenDialog(new JFrame());

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jFileChooser.getSelectedFile();
			fileName = selectedFile.getAbsolutePath();
		}
		System.out.println(fileName);
		getContentsFromFile(fileName);

	}

	public void getContentsFromFile(String fname) {
		String found, value, id, name = null, email2 = null, emailIds = null;
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(fname));) {
			while ((value = br.readLine()) != null) {

				Scanner scan = new Scanner(value);
				scan.useDelimiter(";");
				id = scan.next();
				name = scan.next();
				email2 = scan.next();
				
				emailIds=sb.append(email2).append(",").toString();
			}
			emailIds = emailIds.replaceAll(",$","");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		reciever.setText(emailIds);

	}
}
