package cn.it.shop.Dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.Dao.AccountDao;
import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {
	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
		super(Account.class);
	}
}
