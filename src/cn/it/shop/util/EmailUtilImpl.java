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
		//��¼�ʼ��ͻ��ˣ������ػ�session��
		Properties prop = new Properties();
		Session session = null;
		Message message = null;
		Transport transport = null;
		try{
			prop.setProperty("mail.transport.protocol", "smtp");
			//������session�Ự
			session = javax.mail.Session.getDefaultInstance(prop);
			//����debugģʽ���Է�����Ϣ
			session.setDebug(true);
			//����һ���ʼ�����
			message = new MimeMessage(session);
			//д��
			message.setSubject("����֧���ɹ��ʼ�");
			//��������
			message.setContent("����" + id + "�Ѿ�֧���ɹ�", "text/html;charset=utf-8");
			//�����˵�ַ
			message.setFrom(new InternetAddress(user));
			//���÷�������
			message.setSentDate(new Date());
			transport = session.getTransport();
			transport.connect("smtp.163.com", user, password);
			//�����ռ��˵�ַ�����ҷ����ʼ�
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
