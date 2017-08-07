package shop;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class AccountImplTest {
	@Resource
	private AccountService accountService;
	
	@Test
	public void testSave() {
		accountService.save(new Account("amdin", "Сǿ", "admin"));
	}

}
