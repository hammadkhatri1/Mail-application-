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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class AddTemplate extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JLabel lblBody;
	private JTextArea temp;

	public AddTemplate() {
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
		setTitle("Add Template");

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(47, 23, 70, 15);
		contentPane.add(lblName);

		name = new JTextField();
		name.setBounds(161, 21, 114, 19);
		contentPane.add(name);
		name.setColumns(10);

		lblBody = new JLabel("body:");
		lblBody.setBounds(47, 68, 70, 15);
		contentPane.add(lblBody);

		temp = new JTextArea();

		JScrollPane sc=new JScrollPane(temp);
		sc.setBounds(161, 68, 231, 127);
		contentPane.add(sc);
		
		JButton btnAddTemplate = new JButton("add Template");
		btnAddTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Templates t = new Templates();
				t.setName(name.getText());
				t.setTemp(temp.getText());
				addTemp(t);
			}
		});
		btnAddTemplate.setBounds(275, 207, 117, 25);
		contentPane.add(btnAddTemplate);

		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TemplatesMenu tm = new TemplatesMenu();
				tm.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(12, 207, 117, 25);
		contentPane.add(btnBack);
	}

	private void addTemp(Templates temp) {
		try {
			Templates t = new Templates();
			t = temp;
			FileWriter template = new FileWriter("src/resources/template/" + t.getName()+".txt", true);

			template.write(t.getTemp());
			template.write("\r\n");

			template.flush();
			template.close();

			FileWriter name = new FileWriter("src/resources/template.txt", true);

			name.write(t.getName());
			name.write("\r\n");

			name.flush();
			name.close();

		} catch (Exception c) {
			JOptionPane.showMessageDialog(null, "error while adding template");
		}
		JOptionPane.showMessageDialog(null, "Record Added successfully");

	}
}

