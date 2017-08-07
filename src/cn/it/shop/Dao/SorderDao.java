package cn.it.shop.Dao;

import java.util.List;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

public interface SorderDao extends BaseDao<Sorder> {
	
	List<Object> querySale(int number);
}
