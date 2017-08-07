package cn.it.shop.service.impl;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
		super(Account.class);
	}
}
