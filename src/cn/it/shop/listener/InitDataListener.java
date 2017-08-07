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
//		解决方案1：不可取，会把Spring配置文件加载两次
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-*.xml");
//		productService= (ProductService) applicationContext.getBean("productService");
		//解决方案二：直接到servletcontext中取得Spring配置文件，此方案key不容易记住
//		ApplicationContext applicationContext = (ApplicationContext) sce.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		productService = (ProductService) applicationContext.getBean("productService");
//		System.out.println("product: " + productService);
		//解决方案三：使用工具类
		ApplicationContext applicationContext = (ApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		productTimerTask = (ProductTimerTask) applicationContext.getBean("productTimerTask");
		fileUpload = (FileUpload) applicationContext.getBean("fileUpload");
		//把内置对象交给productTimerTask
		productTimerTask.setApplication(sce.getServletContext());
		//通过计时器，让首页数据一段时间更新一次
		new Timer(true).schedule(productTimerTask, 0, 1000*60*60);
		sce.getServletContext().setAttribute("bankList", fileUpload.getBankImage());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
