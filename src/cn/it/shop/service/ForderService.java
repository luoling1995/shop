package cn.it.shop.service;

import cn.it.shop.model.Forder;

public interface ForderService extends BaseService<Forder> {
	//�����ܼ۸�
	public double cluTotal(Forder forder);
	
	//���¶���״̬
	public void updateStatusById(int id,int sid);
}
