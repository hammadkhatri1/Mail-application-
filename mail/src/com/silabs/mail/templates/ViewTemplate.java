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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;




public class ViewTemplate  extends JFrame {
	

			private JPanel contentPane;

			public ViewTemplate() {

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

				
				try {
					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					
					setTitle("Template details");
					setSize(600, 350);
					
					String columns[] = { "name"}; // Column Names// };
					JTable Table = new JTable();
					DefaultTableModel tableModel;
					// specify number of columns
					tableModel = new DefaultTableModel(0, 1);
					tableModel.setColumnIdentifiers(columns);
					Table.setModel(tableModel);

					String line;
					BufferedReader reader;
					
						reader = new BufferedReader(new FileReader("src/resources/template.txt"));
						while ((line = reader.readLine()) != null) {
							tableModel.addRow(line.split(";"));
						}
						reader.close();

						JScrollPane scrollPane = new JScrollPane(Table);

						scrollPane.setPreferredSize(new Dimension(580, 340));

						contentPane.add(scrollPane);

						
					} catch (Exception f1) {
						JOptionPane.showMessageDialog(null, "Error");
						f1.printStackTrace();
					}
				}
		}



