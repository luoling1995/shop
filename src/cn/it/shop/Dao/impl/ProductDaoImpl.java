package cn.it.shop.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.Dao.ProductDao;
import cn.it.shop.model.Product;
import cn.it.shop.service.ProductService;

@Repository("productDao")
@SuppressWarnings("unchecked")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{
	
	public ProductDaoImpl() {
		super(Product.class);
	}
	
	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		String hql = "from Product p left join fetch p.category where p.name like ?";
		return getSession().createQuery(hql)
				.setString(0, "%" + name + "%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public Long getCount(String name) {
		String hql = "select count(p) from Product p where p.name like ?";
		return (long)getSession().createQuery(hql).setString(0, "%" + name + "%").uniqueResult();
	}

	@Override
	public List<Product> queryByCid(int cid) {
		String hql = "from Product p join fetch p.category where p.commend=true and p.open=true and p.category.id=? order by date desc";
		return getSession().createQuery(hql)
				.setInteger(0, cid)
				.setFirstResult(0)
				.setMaxResults(4)
				.list();
	}
	
}
