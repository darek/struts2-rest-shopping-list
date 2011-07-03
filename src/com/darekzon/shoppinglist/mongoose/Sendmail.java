package com.darekzon.shoppinglist.mongoose;

import javax.mail.MessagingException;

public interface Sendmail {

	public String getProperty(String name);
	public void sendMail(String toMail,String toName,String subject, String message) throws MessagingException;
	
}
