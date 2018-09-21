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
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class DeleteAccount extends JFrame {

	private JPanel contentPane;
	private JTextField StdIDDel;

	/**
	 * Create the frame.
	 */
	public DeleteAccount() {
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
		setTitle("Delete student");

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Email");

		JLabel lblEnterIdTo = new JLabel("enter id to delete");
		lblEnterIdTo.setBounds(30, 104, 126, 14);
		contentPane.add(lblEnterIdTo);

		StdIDDel = new JTextField();
		StdIDDel.setBounds(165, 101, 86, 20);
		contentPane.add(StdIDDel);
		StdIDDel.setColumns(10);

		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int dec = JOptionPane.showConfirmDialog(null, "ARE YOU SURE");
					if (dec == JOptionPane.OK_OPTION) {

						Accounts a = new Accounts();

						a.setId(StdIDDel.getText());

						deletestud(a);
					} else {
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		btnDelete.setBounds(131, 217, 89, 23);
		contentPane.add(btnDelete);

		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AccountsMenu sm = new AccountsMenu();
				sm.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(10, 11, 89, 23);
		contentPane.add(btnHome);

		JButton btnViewStudents = new JButton("view students");
		btnViewStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAccount va = new ViewAccount();
				va.setVisible(true);

			}
		});
		btnViewStudents.setBounds(293, 99, 117, 25);
		contentPane.add(btnViewStudents);
	}

	private void deletestud(Accounts a) throws FileNotFoundException {
		Accounts ad = new Accounts();
		ad = a;
		File file = new File("src/resources/accounts.txt");
		String found, value2 = null, id, email, name;
		String lineread = "", oldtext = "";

		here: try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Scanner scan = new Scanner(file);

			while (scan.hasNext()) {
				found = scan.nextLine();

				if (found.startsWith(ad.getId())) {
					value2 = found;

					Scanner find = new Scanner(value2);
					find.useDelimiter(";");
					id = find.next();
					name = find.next();
					email = find.next();
				}
			}
			if (value2 == null) {
				System.out.println("account of " + ad.getId() + " ID not found");
				System.out.println();
				break here;
			}
			while (((lineread = reader.readLine()) != null)) {
				oldtext += lineread + "\r\n";
			}
			reader.close();

			String newtext = oldtext.replaceAll(value2, " null;null;null;null;null");

			FileWriter writer = new FileWriter("src/resources/accounts.txt");
			writer.write(newtext);
			writer.close();

			System.out.println("Record deleted");

		} catch (IOException e) {
			System.out.println("error deleting file text");
		}
		JOptionPane.showMessageDialog(null, "Record deleted successfully");

	}

}

