package com.dcnetworkdisk.common.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 用于处理email相关操作的类
 * @author DC
 *
 */
public class EmailUtil {
	
	/**
	 * 用正则表达式验证email的合法性
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email){
		return true;
	}
	
	/**
	 * 向指定的邮箱发送邮件
	 * @param email 目标邮箱
	 * @param msg 要发送的消息
	 */
	public static void sendEmail(String email, String msg){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.163.com");
		props.put("mail.smtp.auth", true);
		MyAuthenticator myauth = new MyAuthenticator();
		Session session = Session.getInstance(props, myauth);
		session.setDebug(true);
		Message message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress("huanglong0438@163.com"));
				message.setText(msg);
				message.setSubject("DcNetworkDisk Test");
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				Transport.send(message);
			} catch (AddressException e){
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	}
	
	public static class MyAuthenticator extends Authenticator{

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("huanglong0438@163.com", "aspirine38");
		}
		
	}
}
