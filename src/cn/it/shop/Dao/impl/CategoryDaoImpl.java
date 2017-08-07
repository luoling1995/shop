package cn.it.shop.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.Dao.CategoryDao;
import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

@Repository("categoryDao")
@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
	public CategoryDaoImpl(){
		super(Category.class);
	}

	@Override
	public List<Category> queryJoinAccount(String type,int page,int size) {
		String hql = "from Category c left join fetch c.account where c.type like ?";
		return getSession().createQuery(hql)
				.setString(0, "%" + type + "%")
				.setFirstResult((page - 1) * size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public long getCount(String type) {
		String hql = "select count(c) from Category c where c.type like ?";
		return (long)getSession().createQuery(hql).setString(0, "%" + type + "%").uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		String hql = "delete from Category c where c.id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		String hql = "from Category c where c.hot = ?";
		return getSession().createQuery(hql).setBoolean(0, hot).list();
	}
	
}
