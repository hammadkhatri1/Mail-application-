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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.swing.JOptionPane;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public SendMail(SenderDetails details) throws IOException {

		String nameAll = null;
		SenderDetails sd = new SenderDetails();
		sd = details;

		String username = sd.getSenderId();
		String pwd = sd.getSenderpassword();
		String subject = sd.getSubject();
		String host = sd.getHost();
		String port = sd.getPort();
		String reciever = sd.getReciever();

		String[] ids = reciever.split(",", -1);
		StringBuilder sb = new StringBuilder();

		int dec = JOptionPane.showConfirmDialog(null, "ARE YOU SURE");
		if (dec == JOptionPane.OK_OPTION) {
			for (int i = 0; i < ids.length; i++) {
				String body = sd.getBody();
				String name = changingName(ids[i]);
				body = body.replaceAll("<student>", name);
				// String id = changingIds(ids[i]);
				sendEmail(ids[i], username, pwd, subject, body, host, port, name);

				nameAll = sb.append(name).append(",").toString();
			}
			nameAll = nameAll.replaceAll(",$", "");

			JOptionPane.showMessageDialog(null, "Email Sent to " + nameAll);

		
		} else {
		}
	}

	private String changingName(String email) {
		String found, value2, id, name = null, email2;

		try {
			File file = new File("src/resources/allstudents.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Scanner scan = new Scanner(file);

			while (scan.hasNext()) {

				found = scan.nextLine();

				if (found.contains(email)) {
					value2 = found;

					Scanner find = new Scanner(value2);
					find.useDelimiter(";");
					id = find.next();
					name = find.next();
					email2 = find.next();
				}
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	private String changingIds(String ids) {
		String found, value2, id, name = null, email2 = null;

		try {
			File file = new File("src/resources/allstudents.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Scanner scan = new Scanner(file);

			while (scan.hasNext()) {

				found = scan.nextLine();

				if (found.contains(ids)) {
					value2 = found;

					Scanner find = new Scanner(value2);
					find.useDelimiter(";");
					id = find.next();
					name = find.next();
					email2 = find.next();
				}
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return email2;
	}

	public static void sendEmail(String to, String from, String pwd, String subject, String text, String Host,
			String Port, String name) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", Host);
		props.put("mail.smtp.port", Port);

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pwd);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
