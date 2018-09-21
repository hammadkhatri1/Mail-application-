/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silabs.mail.templates;

/**
 *
 * @author hammad
 */

import com.silabs.mail.main.MainApplication;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TemplatesMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public TemplatesMenu() {

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
		setTitle("Templates Menu");

		JButton btnAddTemplates = new JButton("add templates");
		btnAddTemplates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTemplate ad = new AddTemplate();
				ad.setVisible(true);
				dispose();
			}
		});
		btnAddTemplates.setBounds(73, 123, 117, 25);
		contentPane.add(btnAddTemplates);

		JButton btnView = new JButton("view");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTemplate vt = new ViewTemplate();
				vt.setVisible(true);

			}
		});
		btnView.setBounds(252, 123, 117, 25);
		contentPane.add(btnView);

		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainApplication ma = new MainApplication();
				ma.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(12, 174, 117, 25);
		contentPane.add(btnBack);

		ImageIcon background = new ImageIcon("src/resources/images/suffaLogo.jpg");
		JLabel label = new JLabel();
		label.setBounds(110, 12, 80, 80);
		label.setIcon(background);
		contentPane.add(label);

		ImageIcon background1 = new ImageIcon("src/resources/images/silabs.jpg");
		JLabel label1 = new JLabel();
		label1.setBounds(255, 12, 80, 80);
		label1.setIcon(background1);
		contentPane.add(label1);

	}

}
