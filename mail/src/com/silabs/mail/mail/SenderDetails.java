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
public class SenderDetails {
String senderId;
String senderpassword;
String host;
String port;
String reciever;

public String getSenderId() {
	return senderId;
}
public void setSenderId(String senderId) {
	this.senderId = senderId;
}
public String getSenderpassword() {
	return senderpassword;
}
public void setSenderpassword(String senderpassword) {
	this.senderpassword = senderpassword;
}
public String getHost() {
	return host;
}
public void setHost(String host) {
	this.host = host;
}
public String getPort() {
	return port;
}
public void setPort(String port) {
	this.port = port;
}
public String getReciever() {
	return reciever;
}
public void setReciever(String reciever) {
	this.reciever = reciever;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}
 String subject;
String body;

}
