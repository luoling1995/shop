package cn.it.shop.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

//http://utf8.sms.webchinese.cn/?Uid=本站用户名&Key=接口安全秘钥&smsMob=手机号码&smsText=验证码:8888

@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {
	
	public void sendMessage(String phoneNumber,String id){
		//打开IE浏览器
		HttpClient client = new HttpClient();
		//使用post请求
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		//添加post参数和设置http头信息
		post.addParameter("Uid", "luo_jing");
		post.addParameter("Key", "4f9fb141d76b6a0f0058");
		post.addParameter("smsMob", "13037232552");
		post.addParameter("smsText", "发个短信测试一下");
		post.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
		int code;
		try {
			//提交请求
			code = client.executeMethod(post);
			System.out.println("http状态码为" + code);
			//获取服务器返回的信息
			String result = post.getResponseBodyAsString();
			System.out.println("发送结果为：" + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			post.releaseConnection();
		}
		
	}
}
