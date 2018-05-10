package com.jiayaming.myweb.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtil {
	public static void sendMail(String to,String code) {
		//创建连接对象，连接到邮箱服务器
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.auth","true");
		try {
			MailSSLSocketFactory sFactory = new MailSSLSocketFactory();
			sFactory.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.socketFactory",sFactory);
		} catch (GeneralSecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("904133395@qq.com", "efflyirmxjkpbbfb");
			}
		});
		
		//创建邮件对象
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("904133395@qq.com"));
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject("这是来自自己开发的软件发送的邮件");
			message.setContent("<h1>来时是打发斯蒂芬</h1><h3><a href='http://localhost:8082/myweb/view/register.html'>http://localhost:8082/myweb/view/register.html</a></h3>", "text/html;charset=UTF-8");
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
