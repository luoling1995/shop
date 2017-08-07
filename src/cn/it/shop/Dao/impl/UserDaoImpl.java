package cn.it.shop.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.Dao.UserDao;
import cn.it.shop.model.User;
import cn.it.shop.service.UserService;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	public UserDaoImpl() {
		super(User.class);
	}
	
	@Override
	public User login(User user) {
		String hql = "from User u where u.login = ? and u.pass = ?";
		return (User) getSession().createQuery(hql).setString(0, user.getLogin())
			.setString(1, user.getPass()).uniqueResult();
	}
	
}
