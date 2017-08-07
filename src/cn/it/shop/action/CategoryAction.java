package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import cn.it.shop.model.Category;

@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String queryJoinAccount(){
		//用来存储分页的数据
		pageMap = new HashMap<String,Object>();
		System.out.println("type: " + model.getType());
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList);
		pageMap.put("total", categoryService.getCount(model.getType()));
		return "jsonMap";
	}
	
	public String deleteByIds(){
		categoryService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		categoryService.save(model);
	}
	
	public void update(){
		categoryService.update(model);
	}
	
	public String query(){
		jsonList =  categoryService.query();
		return "jsonList";
	}
}
