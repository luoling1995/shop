package cn.it.shop.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.Dao.SorderDao;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.SorderService;
import net.sf.json.JSONSerializer;

@Repository("sorderDao")
public class SorderDaoImpl extends BaseDaoImpl<Sorder> implements SorderDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> querySale(int number) {
		String hql = "select s.name,sum(s.number) from Sorder s join s.product group by s.product.id";
		return getSession().createQuery(hql).setFirstResult(0)
				.setMaxResults(number).list();
	}

	

}
