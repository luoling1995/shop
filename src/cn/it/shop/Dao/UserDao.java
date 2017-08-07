package cn.it.shop.Dao;

import cn.it.shop.model.User;

public interface UserDao extends BaseDao<User> {
	public User login(User user);
}
