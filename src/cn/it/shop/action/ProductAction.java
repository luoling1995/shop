package cn.it.shop.action;

import java.util.HashMap;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.it.shop.model.Product;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String queryJoinProduct(){
		//用来存储分页的数据
		pageMap = new HashMap<String,Object>();
		List<Product> productList = productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows", productList);
		pageMap.put("total", productService.getCount(model.getName()));
		return "jsonMap";
	}
	
	public void save() {
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		System.out.println("model: " + model);
		productService.save(model);
	}
	
	public String get(){
		request.put("product", productService.get(model.getId()));
		return "detail";
	}
}
