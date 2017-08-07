package cn.it.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;

@Component
public class ProductTimerTask extends TimerTask {
	@Resource
	private ProductService productService;
	@Resource
	private CategoryService categoryService;
	private ServletContext application;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
	@Override
	public void run() {
		System.out.println("----run----");
		List<List<Product>> bigList = new ArrayList<List<Product>>();
		for(Category category:categoryService.queryByHot(true)){
			bigList.add(productService.queryByCid(category.getId()));
		}
		application.setAttribute("bigList", bigList);
	}

}
