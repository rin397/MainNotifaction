package com.bxb.unitest;

import java.util.ArrayList;
import java.util.List;

import com.bxb.util.MailNotificationUtil;

public class MailUnitest {
	
	public static String mailFrom="";
	
	public static String mailTo="";
	
	public static String mailContent="";
	
	public static String mailAttachment="";
	
	public static String mailTitle="";
	
	public static List<String> mailTos= new ArrayList<String>();

	public static void main(String[] args) {
		System.out.print(1);
		MailNotificationUtil.mailTo(mailFrom, mailTo,mailTitle, mailContent, mailAttachment);
	
		MailNotificationUtil.mailToByList(mailFrom,  mailTos,mailTitle, mailContent, mailAttachment);

	}
	
	

}
