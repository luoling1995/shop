package cn.it.shop.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

//http://utf8.sms.webchinese.cn/?Uid=��վ�û���&Key=�ӿڰ�ȫ��Կ&smsMob=�ֻ�����&smsText=��֤��:8888

@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {
	
	public void sendMessage(String phoneNumber,String id){
		//��IE�����
		HttpClient client = new HttpClient();
		//ʹ��post����
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		//���post����������httpͷ��Ϣ
		post.addParameter("Uid", "luo_jing");
		post.addParameter("Key", "4f9fb141d76b6a0f0058");
		post.addParameter("smsMob", "13037232552");
		post.addParameter("smsText", "�������Ų���һ��");
		post.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
		int code;
		try {
			//�ύ����
			code = client.executeMethod(post);
			System.out.println("http״̬��Ϊ" + code);
			//��ȡ���������ص���Ϣ
			String result = post.getResponseBodyAsString();
			System.out.println("���ͽ��Ϊ��" + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			post.releaseConnection();
		}
		
	}
}
