package cn.it.shop.service;
 
import java.util.List;

import cn.it.shop.model.Product;

public interface ProductService extends BaseService<Product>{
	//查询类别信息，级联管理员
	public List<Product> queryJoinCategory(String name,int page,int size);
	
	//根据关键字查询总记录数
	public Long getCount(String name);
	
	//根据热点类别，查询当前类别推荐商品（仅仅查询4个）
	public List<Product> queryByCid(int cid);
}
 