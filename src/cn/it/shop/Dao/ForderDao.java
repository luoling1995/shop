package cn.it.shop.Dao;

import cn.it.shop.model.Forder;

public interface ForderDao extends BaseDao<Forder> {
	
	//���¶���״̬
	public void updateStatusById(int id,int sid);
}
