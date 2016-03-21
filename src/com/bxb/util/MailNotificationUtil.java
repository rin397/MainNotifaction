package com.bxb.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailNotificationUtil {

	public static void mailTo(final String mailFrom,final String pwd, String mailTo,String mailTitle, String mailContent, String mailAttachment) throws AddressException, MessagingException {
		System.out.println("its mail to by  process start");
		System.out.println("its mail to by 9999list process end");
		
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		
		
		
//		Properties.put("mail.store.protocol", "pop3s");
//		Properties.put("mail.pop3.host", "pop.gmail.com");     
//		Properties.put("mail.pop3.user", Application.email);
//		Properties.put("mail.pop3.socketFactory", 995);
//		Properties.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		Properties.put("mail.pop3.port", 995);

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailFrom, pwd);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(mailFrom));
		InternetAddress[] toAddresses = { new InternetAddress(mailTo) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(mailTitle);
		msg.setSentDate(new Date());
		msg.setText(mailContent);
		
		String messageText = "Sending a file with FileDataSource\n";
		 MimeBodyPart messageBodyPart1 = new MimeBodyPart();
         messageBodyPart1.setText(messageText);

         MimeBodyPart messageBodyPart2 = new MimeBodyPart();

         // attach the file to the message
         FileDataSource fdatasource = new FileDataSource(mailAttachment);
         messageBodyPart2.setDataHandler(new DataHandler(fdatasource));
         messageBodyPart2.setFileName(fdatasource.getName());
         
         Multipart mpart = new MimeMultipart();
         mpart.addBodyPart(messageBodyPart1);
         mpart.addBodyPart(messageBodyPart2);
         msg.setContent(mpart);

         
		// sends the e-mail
		Transport.send(msg);
	}

	
	
	
	public static void mailToByList(String mailFrom,String pwd,String[] mailTos, String mailTitle, String mailContent, String mailAttachment) {
		System.out.println("its mail to by 88888list process start");
		System.out.println("its mail to process end");
	}
	
}