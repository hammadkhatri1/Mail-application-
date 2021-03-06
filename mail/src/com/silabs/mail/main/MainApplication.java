/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silabs.mail.main;

/**
 *
 * @author hammad
 */

import com.silabs.mail.accounts.AccountsMenu;
import com.silabs.mail.mail.SelectTemplate;
import com.silabs.mail.templates.TemplatesMenu;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MainApplication extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication frame = new MainApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApplication() {
		initComponents();

		CenteredFrame(this);

	}

	public void CenteredFrame(javax.swing.JFrame objFrame) {
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
		int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
		objFrame.setLocation(iCoordX, iCoordY);
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("MAIN MENU");

		JButton btnNewButton = new JButton("Send Mail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectTemplate st = new SelectTemplate();
				
				//st.setVisible(true);

				dispose();
			}
		});
		btnNewButton.setBounds(63, 138, 117, 25);
		contentPane.add(btnNewButton);

		JButton btnTemplates = new JButton("Templates");
		btnTemplates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TemplatesMenu tm = new TemplatesMenu();
				tm.setVisible(true);
				dispose();
			}
		});
		btnTemplates.setBounds(252, 138, 117, 25);
		contentPane.add(btnTemplates);

		JButton btnAccounts = new JButton("Accounts");
		btnAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountsMenu at = new AccountsMenu();
				at.setVisible(true);
				dispose();
			}
		});
		btnAccounts.setBounds(149, 198, 117, 25);
		contentPane.add(btnAccounts);

		ImageIcon background = new ImageIcon("src/resources/images/suffaLogo.jpg");
		JLabel label = new JLabel();
		label.setBounds(131, 12, 81, 81);
		label.setIcon(background);
		contentPane.add(label);

		ImageIcon background1 = new ImageIcon("src/resources/images/silabs.jpg");
		JLabel label1 = new JLabel();
		label1.setBounds(252, 12, 81, 81);
		label1.setIcon(background1);
		contentPane.add(label1);

	}
}
