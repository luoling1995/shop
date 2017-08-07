package cn.it.shop.Dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.Dao.BaseDao;
import cn.it.shop.service.BaseService;

@SuppressWarnings("unchecked")
@Repository("baseDao")
//@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T>{
	private Class<T> clazz;
	@Resource
	private SessionFactory sessionFactory;
	
	public BaseDaoImpl(Class<T> clazz) {
//		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
//		clazz = (Class) type.getActualTypeArguments()[0];
		this.clazz = clazz;
	}
	
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		String hql = "delete from " + clazz.getSimpleName() + " c where c.id=?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

	@Override
	public T get(int id) {
		return (T) getSession().get(clazz, id);
	}
	
	@Override
	public List<T> query() {
		String hql = "from " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

	
}
