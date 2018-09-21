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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;



public class UpdateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField IDUpdate;
	private JTextField StdUpdName;
	private JTextField StdUpdEmail;
	private JButton btnUpdate;
	private JButton btnHome;

	public UpdateAccount() {
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
		setTitle("Update Account");

		JLabel lblUpdateStudents = new JLabel("UPDATE STUDENTS");
		lblUpdateStudents.setBounds(156, 34, 125, 14);
		contentPane.add(lblUpdateStudents);

		JLabel lblEnterIdTo = new JLabel("enter id to update");
		lblEnterIdTo.setBounds(25, 97, 154, 14);
		contentPane.add(lblEnterIdTo);

		IDUpdate = new JTextField();
		IDUpdate.setBounds(211, 94, 154, 20);
		contentPane.add(IDUpdate);
		IDUpdate.setColumns(10);

		JLabel lblEnterName = new JLabel("enter name");
		lblEnterName.setBounds(25, 150, 101, 14);
		contentPane.add(lblEnterName);

		StdUpdName = new JTextField();
		StdUpdName.setBounds(211, 147, 154, 20);
		contentPane.add(StdUpdName);
		StdUpdName.setColumns(10);

		JLabel lblEnterStudentEmail = new JLabel("enter student email");
		lblEnterStudentEmail.setBounds(25, 204, 101, 14);
		contentPane.add(lblEnterStudentEmail);

		StdUpdEmail = new JTextField();
		StdUpdEmail.setBounds(211, 198, 154, 20);
		contentPane.add(StdUpdEmail);
		StdUpdEmail.setColumns(10);

		btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dec = JOptionPane.showConfirmDialog(null, "ARE YOU SURE");
				if (dec == JOptionPane.OK_OPTION) {

					Accounts a = new Accounts();
					a.setId(IDUpdate.getText());
					a.setName(StdUpdName.getText());
					a.setEmail(StdUpdEmail.getText());

					update(a);
				} else {
				}
			}

		});
		btnUpdate.setBounds(153, 239, 89, 23);
		contentPane.add(btnUpdate);

		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AccountsMenu sm = new AccountsMenu();
				sm.setVisible(true);
				dispose();

			}
		});
		btnHome.setBounds(10, 11, 89, 23);
		contentPane.add(btnHome);

		setVisible(true);
	}

	private void update(Accounts abc) {
		String found, value2 = null, id, value1, name, email, addtext = null, b_author, b_type, b_date;
		String lineread = "", oldtext = "";

		here: try {
			Accounts ab = new Accounts();
			ab = abc;

			File file = new File("src/resources/accounts.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Scanner scan = new Scanner(file);

			while (scan.hasNext()) {

				found = scan.nextLine();

				if (found.startsWith(ab.getId())) {
					value2 = found;

					Scanner find = new Scanner(value2);
					find.useDelimiter(";");
					id = find.next();
					name = find.next();
					email = find.next();
				}
			}

			if (value2 == null) {
				JOptionPane.showMessageDialog(null, "Record NOT found");

				break here;
			}

			while (((lineread = reader.readLine()) != null)) {
				oldtext += lineread + "\r\n";
			}

			reader.close();

			addtext = ab.getId() + ";" + ab.getName() + ";" + ab.getEmail();

			String newtext = oldtext.replaceAll(value2, addtext);

			FileWriter writer = new FileWriter("src/resources/accounts.txt");

			writer.write(newtext);
			writer.close();

		} catch (

		IOException e) {
			System.out.println("error updating account file");
		}
		JOptionPane.showMessageDialog(null, "Record updated successfully");

	}

}
