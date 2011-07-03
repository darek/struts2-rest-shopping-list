package com.darekzon.shoppinglist.mongoose;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendmailImpl implements Sendmail {

	private Properties properties = new Properties();
	
	private Session session;
	
	public SendmailImpl(){
		this.readProperties();
		Logger.getLogger(this.getClass().toString()).log(Level.INFO, "Starting Sendmail");
		session = Session.getInstance(properties);
	}
	
	private void readProperties() {
		try {
			properties.load(this.getClass().getResourceAsStream("/mail.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Sendmail fatal error. Please provide mail configuration in database.properties file");
		}			
	}
	
	public void sendMail(String toMail,String toName,String subject, String message) throws MessagingException{
		MimeMessage mm = new MimeMessage(session);
		try {
			mm.setFrom(new InternetAddress(properties.getProperty("mail.from.mail"),properties.getProperty("mail.from.name")));
			mm.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail,toName));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("unsuported encoding");
			e.printStackTrace();
		}
		
		mm.setText(message);
		mm.setSubject(subject);
		Transport t = session.getTransport("smtp");
		t.connect(this.getProperty("mail.user"),this.getProperty("mail.password"));
		
		t.sendMessage(mm, mm.getAllRecipients());
	}
	
	public String getProperty(String name){
		return properties.getProperty(name);
	}
}
