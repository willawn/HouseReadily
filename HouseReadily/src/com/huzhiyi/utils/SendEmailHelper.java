package com.huzhiyi.utils;


import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class SendEmailHelper {
	
	public static void main(String[] args) {
		sendEmailToSina("chao145@163.com", "测试(III)", "内容"); 
	}
	
	
	public static void sendEmail(String toEmail,String str_title,String str_content) { 

		try { 
			//建立邮件会话 
			Properties props=new Properties(); // 
			//存储发送邮件服务器的信息 
			props.put("mail.smtp.host","smtp.163.com"); //smtp.163.com
			//同时通过验证 
			props.put("mail.smtp.auth","true"); 
			
			//props.setProperty("mail.smtp.port", "143"); 
			//根据属性新建一个邮件会话 
			Session s=Session.getInstance(props); 
			s.setDebug(false); //
	
			//由邮件会话新建一个消息对象 
			MimeMessage message=new MimeMessage(s); 
	
			//设置邮件 
			InternetAddress from= new InternetAddress("zushou365_KG@163.com"); 
			message.setFrom(from); //设置发件人的地址 
			// 
			// //设置收件人,并设置其接收类型为TO 
			InternetAddress to=new InternetAddress(toEmail) ; // 
			message.setRecipient(Message.RecipientType.TO, to); 
	
			//设置标题 
			message.setSubject(str_title); //java学习 
	
			//设置信件内容 
			// message.setText(str_content); //发送文本邮件 //你好吗？ 
			message.setContent(str_content, "text/html;charset=gbk"); // 
			//设置发信时间 
			message.setSentDate(new Date()); 
	
			//存储邮件信息 
			message.saveChanges(); 
	
			//发送邮件 
			Transport transport=s.getTransport("smtp"); 
			//以smtp方式登录邮箱,第一个参数是发送邮件用的邮件服务器SMTP地址,第二个参数为用户名,第三个参数为密码 
			transport.connect("smtp.163.com","zushou365_KG@163.com","lanchaoqiang145"); 
			//发送邮件,其中第二个参数是所有已设好的收件人地址 
			transport.sendMessage(message,message.getAllRecipients()); 
			transport.close(); 

		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		System.out.println("email send !");
		} 

	
	
	public static void sendEmailToSina(String toEmail,String str_title,String str_content){
		try { 
			long times = System.currentTimeMillis(); 
			//建立邮件会话 
			Properties props=new Properties(); // 
			//存储发送邮件服务器的信息 
			props.put("mail.smtp.host","smtp.sina.com"); //smtp.163.com
			//同时通过验证 
			props.put("mail.smtp.auth","true"); 
			
			//props.setProperty("mail.smtp.port", "143"); 
			//根据属性新建一个邮件会话 
			Session s=Session.getInstance(props); 
			s.setDebug(false); //
	
			//由邮件会话新建一个消息对象 
			MimeMessage message=new MimeMessage(s); 
	
			//设置邮件 
			InternetAddress from= new InternetAddress("zushou365@sina.com"); 
			message.setFrom(from); //设置发件人的地址 
			// 
			// //设置收件人,并设置其接收类型为TO 
			InternetAddress to=new InternetAddress(toEmail) ; // 
			message.setRecipient(Message.RecipientType.TO, to); 
	
			//设置标题 
			message.setSubject(str_title); //java学习 
	
			//设置信件内容 
			// message.setText(str_content); //发送文本邮件 //你好吗？ 
			
			message.setContent(str_content, "text/html;charset=gbk"); // 
			//设置发信时间 
			message.setSentDate(new Date()); 
	
			//存储邮件信息 
			message.saveChanges(); 
	
			//发送邮件 
			Transport transport=s.getTransport("smtp"); 
			//以smtp方式登录邮箱,第一个参数是发送邮件用的邮件服务器SMTP地址,第二个参数为用户名,第三个参数为密码 
			transport.connect("smtp.sina.com","zushou365@sina.com","zushou365.com"); 
			//发送邮件,其中第二个参数是所有已设好的收件人地址 
			transport.sendMessage(message,message.getAllRecipients()); 
			transport.close(); 

		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		System.out.println("email send !");
	}
	
	
	/**
	 * 发送多收件人
	 * @param toEmail
	 * @param str_title
	 * @param str_content
	 */
	public static void sendEmailToSinas(String[] emails,int receiverCount,String str_title,String str_content){
		try { 
			long times = System.currentTimeMillis(); 
			//建立邮件会话 
			Properties props=new Properties(); // 
			//存储发送邮件服务器的信息 
			props.put("mail.smtp.host","smtp.sina.com"); //smtp.163.com
			//同时通过验证 
			props.put("mail.smtp.auth","true"); 
			
			//props.setProperty("mail.smtp.port", "143"); 
			//根据属性新建一个邮件会话 
			Session s=Session.getInstance(props); 
			s.setDebug(false); //
	
			//由邮件会话新建一个消息对象 
			MimeMessage message=new MimeMessage(s); 
	
			//设置邮件 
			InternetAddress from= new InternetAddress("zushou365@sina.com"); 
			message.setFrom(from); //设置发件人的地址 
			// 
			// //设置收件人,并设置其接收类型为TO 
			 // 多个收件人的地址  
			InternetAddress[] address = new InternetAddress[receiverCount];
			for (int i = 0; i < receiverCount; i++) {
				address[i] = new InternetAddress(emails[i]);
			}
			// 设置收件人  
			message.addRecipients(Message.RecipientType.TO, address);
	
			//设置标题 
			message.setSubject(str_title); //java学习 
	
			//设置信件内容 
			// message.setText(str_content); //发送文本邮件 //你好吗？ 
			
			message.setContent(str_content, "text/html;charset=gbk"); // 
			//设置发信时间 
			message.setSentDate(new Date()); 
	
			//存储邮件信息 
			message.saveChanges(); 
	
			//发送邮件 
			Transport transport=s.getTransport("smtp"); 
			//以smtp方式登录邮箱,第一个参数是发送邮件用的邮件服务器SMTP地址,第二个参数为用户名,第三个参数为密码 
			transport.connect("smtp.sina.com","zushou365@sina.com","zushou365.com"); 
			//发送邮件,其中第二个参数是所有已设好的收件人地址 
			transport.sendMessage(message,message.getAllRecipients()); 
			transport.close(); 

		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		System.out.println("email send !");
	}
}
