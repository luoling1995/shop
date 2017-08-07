package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {
	//计算总价格
	public Forder addSorder(Forder forder,Product product);
	
	public Sorder productToSorder(Product product);
	
	Forder updateSorder(Forder forder,Sorder sorder);
	
	List<Object> querySale(int number);
}
