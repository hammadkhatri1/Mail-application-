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

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;


public class SelectTemplate extends JFrame {

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	private JPanel contentPane;

	ArrayList<String> al = new ArrayList();
	String selectedName;
	String selectedBody;

	public SelectTemplate() {
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

		JPanel contentPane;

		getNameFromFile();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JList jlst = new JList(al.toArray());

		contentPane.setLayout(new FlowLayout());
		setSize(200, 160);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		jlst.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent le) {
				int idx = jlst.getSelectedIndex();
				if (idx != -1) {
					selectedName = al.get(idx);
					return;
				} else
					System.out.println("Please choose a template.");
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);

		contentPane.add(new JScrollPane(jlst));

		JButton btnSelect = new JButton("select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String body = getTemplateFromFile(selectedName);

					GenerateMail gm;

					gm = new GenerateMail(body);

					gm.setVisible(true);

					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnSelect);
		setSize(400, 400);
		setVisible(true);
	}

	public void getNameFromFile() {

		String body = null, value = null;

		try (BufferedReader br = new BufferedReader(new FileReader("src/resources/template.txt"));) {
			while ((value = br.readLine()) != null) {

				@SuppressWarnings("resource")

				String name = value;
				al.add(name);
			}
		} catch (Exception e) {

		}

	}

	public String getTemplateFromFile(String name) {
		String content = null;
		try {
			String found, value2;

			content = new Scanner(new File("src/resources/templates/" + name + ".txt")).useDelimiter("\\Z").next();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
			e.printStackTrace();
		}

		return content;

	}

}
