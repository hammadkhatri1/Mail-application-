/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silabs.mail.accounts;

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
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.event.ActionEvent;

public class AddAccount extends JFrame{

	private JPanel contentPane;
	private JTextField StdID;
	private JTextField StdName;
	private JTextField StdEmail;
	private JButton btnAdd;
	private JButton btnHome;

	public AddAccount() {
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
		setTitle("Add Account");

		StdID = new JTextField();
		StdID.setBounds(191, 60, 86, 20);
		contentPane.add(StdID);
		StdID.setColumns(10);

		StdName = new JTextField();
		StdName.setBounds(191, 104, 176, 20);
		contentPane.add(StdName);
		StdName.setColumns(10);

		StdEmail = new JTextField();
		StdEmail.setBounds(191, 153, 176, 20);
		contentPane.add(StdEmail);
		StdEmail.setColumns(10);

		JLabel lblStudentid = new JLabel("StudentID");
		lblStudentid.setBounds(45, 63, 106, 14);
		contentPane.add(lblStudentid);

		JLabel lblStudentname = new JLabel("StudentName");
		lblStudentname.setBounds(45, 107, 106, 14);
		contentPane.add(lblStudentname);

		JLabel lblStudentEmailid = new JLabel("Student EmailID");
		lblStudentEmailid.setBounds(45, 156, 106, 14);
		contentPane.add(lblStudentEmailid);

		JLabel lblAddStudents = new JLabel("ADD STUDENTS");
		lblAddStudents.setBounds(139, 11, 117, 14);
		contentPane.add(lblAddStudents);

		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int dec = JOptionPane.showConfirmDialog(null, "ARE YOU SURE");
				if (dec == JOptionPane.OK_OPTION) {

					Accounts acc = new Accounts();

					acc.setId(StdID.getText());
					acc.setName(StdName.getText());
					acc.setEmail(StdEmail.getText());

					addacc(acc);
				} else {
				}
			}

		});
		btnAdd.setBounds(167, 213, 89, 23);
		contentPane.add(btnAdd);

		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountsMenu sm = new AccountsMenu();
				sm.setVisible(true);
				dispose();

			}
		});
		btnHome.setBounds(10, 7, 89, 23);
		contentPane.add(btnHome);

		setVisible(true);

	}

	private void addacc(Accounts hello) {
		try {
			Accounts ac = new Accounts();
			ac = hello;
			FileWriter books = new FileWriter("src/resources/accounts.txt", true);

			books.write(ac.getId() + ";");
			books.write(ac.getName() + ";");
			books.write(ac.getEmail() + ";");
			books.write("\n");

			books.flush();
			books.close();

		} catch (Exception c) {
			JOptionPane.showMessageDialog(null, "error adding account");
		}
		JOptionPane.showMessageDialog(null, "Record Added successfully");

	}
}
