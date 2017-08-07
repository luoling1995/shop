package cn.it.shop.Dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.Dao.ForderDao;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.ForderService;

@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements ForderDao{

	public ForderDaoImpl() {
		super(Forder.class);
	}
	
	@Override
	public void updateStatusById(int id, int sid) {
		String hql = "update Forder f set f.status.id = ? where f.id = ?";
		getSession().createQuery(hql).setInteger(0, sid).setInteger(1, id).executeUpdate();
	}

}
