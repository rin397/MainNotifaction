package com.bxb.unitest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.bxb.util.MailNotificationUtil;

public class MailUnitest {
	
	public static String mailTo="chengweichen01@gmail.com";

	public static String pwd="HHZccw199101";
	
	public static String mailFrom="tim.chen@bitsxbites.com";
	
	public static String mailContent="hello email";
	
	public static String mailAttachment="./LP_geometry.pdf";
	
	public static String mailTitle="hello";
	
	public static String[] mailTos = {"chengweichen01@gmail.com"};

	public static void main(String[] args) {
		
		try {
			MailNotificationUtil.mailTo(mailFrom,pwd,mailTo,mailTitle, mailContent, mailAttachment);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//		MailNotificationUtil.mailToByList(mailFrom,pwd, mailTos,mailTitle, mailContent, mailAttachment);ß

	}
	
	
	
	

}
