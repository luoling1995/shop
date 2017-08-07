package cn.it.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cn.it.shop.Dao.AccountDao;
import cn.it.shop.Dao.BaseDao;
import cn.it.shop.Dao.CategoryDao;
import cn.it.shop.Dao.ForderDao;
import cn.it.shop.Dao.ProductDao;
import cn.it.shop.Dao.SorderDao;
import cn.it.shop.Dao.UserDao;
import cn.it.shop.service.BaseService;

@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T>{
	private Class<T> clazz;
	
	protected BaseDao baseDao;
	@Resource
	protected AccountDao accountDao;
	@Resource
	protected CategoryDao categoryDao;
	@Resource
	protected ForderDao forderDao;
	@Resource
	protected ProductDao productDao;
	@Resource
	protected SorderDao sorderDao;
	@Resource
	protected UserDao userDao;
	
	public BaseServiceImpl(Class<T> clazz) {
//		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
//		clazz = (Class) type.getActualTypeArguments()[0];
		this.clazz = clazz;
	}
	
	public BaseServiceImpl() {
		// TODO Auto-generated constructor stub
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@PostConstruct
	public void init(){
		String className = clazz.getSimpleName(); //Account
		String classDao = className.substring(0, 1).toLowerCase() + className.substring(1) + "Dao"; //AccountDao
		try {
			Field field = this.getClass().getSuperclass().getDeclaredField(classDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, field.get(this));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("baseDao + " + baseDao);
	}
	
	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	@Override
	public T get(int id) {
		return (T) baseDao.get(id);
	}
	
	@Override
	public List<T> query() {
		return baseDao.query();
	}

	
}
