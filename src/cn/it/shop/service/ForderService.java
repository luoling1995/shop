package cn.it.shop.service;

import cn.it.shop.model.Forder;

public interface ForderService extends BaseService<Forder> {
	//计算总价格
	public double cluTotal(Forder forder);
	
	//更新订单状态
	public void updateStatusById(int id,int sid);
}
