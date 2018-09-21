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

import com.silabs.mail.main.MainApplication;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;

public class AccountsMenu  extends JFrame{

				private JPanel contentPane;
				private JTextField textField;
				private JTextField textField_1;

				public AccountsMenu() {
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
					setTitle("Accounts Menu");

					
					JButton btnAddAcc = new JButton("insert");
					btnAddAcc.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							AddAccount ad = new AddAccount();
							ad.setVisible(true);
							dispose();
						}
					});
					btnAddAcc.setBounds(112, 101, 117, 25);
					contentPane.add(btnAddAcc);

					JButton btnView = new JButton("View");
					btnView.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ViewAccount v = new ViewAccount();
							v.setVisible(true);

						}
					});
					btnView.setBounds(286, 101, 117, 25);
					contentPane.add(btnView);

					JButton btnDelete = new JButton("Delete");
					btnDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							DeleteAccount da = new DeleteAccount();
							da.setVisible(true);
							dispose();
						}
					});
					btnDelete.setBounds(112, 151, 117, 25);
					contentPane.add(btnDelete);

					JButton btnUpdate = new JButton("Update");
					btnUpdate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							UpdateAccount ua = new UpdateAccount();
							ua.setVisible(true);
							dispose();
						}

					});
					btnUpdate.setBounds(286, 151, 117, 25);
					contentPane.add(btnUpdate);
					
					JButton btnBack = new JButton("back");
					btnBack.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							MainApplication ma=new MainApplication();
							ma.setVisible(true);
							dispose();
						}
					});
					btnBack.setBounds(12, 215, 117, 25);
					contentPane.add(btnBack);
					
					
					ImageIcon background1 = new ImageIcon("src/resources/images/suffaLogo.jpg");
					JLabel label1 = new JLabel();
					label1.setBounds(128, 12,  80, 80);
					label1.setIcon(background1);
					contentPane.add(label1);
					
				
					ImageIcon background = new ImageIcon("src/resources/images/silabs.jpg");
					JLabel label = new JLabel();
					label.setBounds(272, 12, 80, 80);
					label.setIcon(background);
					contentPane.add(label);
					
				}
			

		}

