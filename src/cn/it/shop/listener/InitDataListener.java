package cn.it.shop.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import cn.it.shop.util.FileUpload;
import cn.it.shop.util.ProductTimerTask;

public class InitDataListener implements ServletContextListener {
	private ProductTimerTask productTimerTask = null;
	private FileUpload fileUpload;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
//		�������1������ȡ�����Spring�����ļ���������
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-*.xml");
//		productService= (ProductService) applicationContext.getBean("productService");
		//�����������ֱ�ӵ�servletcontext��ȡ��Spring�����ļ����˷���key�����׼�ס
//		ApplicationContext applicationContext = (ApplicationContext) sce.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		productService = (ProductService) applicationContext.getBean("productService");
//		System.out.println("product: " + productService);
		//�����������ʹ�ù�����
		ApplicationContext applicationContext = (ApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		productTimerTask = (ProductTimerTask) applicationContext.getBean("productTimerTask");
		fileUpload = (FileUpload) applicationContext.getBean("fileUpload");
		//�����ö��󽻸�productTimerTask
		productTimerTask.setApplication(sce.getServletContext());
		//ͨ����ʱ��������ҳ����һ��ʱ�����һ��
		new Timer(true).schedule(productTimerTask, 0, 1000*60*60);
		sce.getServletContext().setAttribute("bankList", fileUpload.getBankImage());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
