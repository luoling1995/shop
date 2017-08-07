package cn.it.shop.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

import javax.mail.Session;

@Component("emailUtil")
public class EmailUtilImpl implements EmailUtil {
	private String user = "13037232552@163.com";
	private String password = "3eXc5WgEimDq6N";
	
	/* (non-Javadoc)
	 * @see cn.it.shop.util.MessageUtil#sendEmail(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendEmail(String address,String id){
		//登录邮件客户端（创建回话session）
		Properties prop = new Properties();
		Session session = null;
		Message message = null;
		Transport transport = null;
		try{
			prop.setProperty("mail.transport.protocol", "smtp");
			//创建了session会话
			session = javax.mail.Session.getDefaultInstance(prop);
			//设置debug模式调试发送信息
			session.setDebug(true);
			//创建一封邮件对象
			message = new MimeMessage(session);
			//写信
			message.setSubject("订单支付成功邮件");
			//正文内容
			message.setContent("订单" + id + "已经支付成功", "text/html;charset=utf-8");
			//发件人地址
			message.setFrom(new InternetAddress(user));
			//设置发送日期
			message.setSentDate(new Date());
			transport = session.getTransport();
			transport.connect("smtp.163.com", user, password);
			//设置收件人地址，并且发送邮件
			transport.sendMessage(message, new Address[]{new InternetAddress(address)});
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally {
			try {
				transport.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
	}
}
